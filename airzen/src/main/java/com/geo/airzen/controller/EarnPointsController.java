package com.geo.airzen.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geo.airzen.dto.EarnPointsDTO;
import com.geo.airzen.dto.MemberDTO;
import com.geo.airzen.entity.EarnPointsAir;
import com.geo.airzen.entity.Member;
import com.geo.airzen.entity.MemberContactInfo;
import com.geo.airzen.entity.MemberDocumentInfo;
import com.geo.airzen.entity.MemberPointDetails;
import com.geo.airzen.entity.MemberPreferences;
import com.geo.airzen.entity.MemberTier;
import com.geo.airzen.entity.Preferences;
import com.geo.airzen.service.AirzenPointsService;
import com.geo.airzen.service.EarnPointsService;
import com.geo.airzen.service.MemberContactService;
import com.geo.airzen.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/airzen/earn")
public class EarnPointsController {

	private MemberService memberService;

	private EarnPointsService earnPointsService;

	private AirzenPointsService airzenPointsService;

	public EarnPointsController(MemberService theMemberService, EarnPointsService theEarnPointsService,
			AirzenPointsService theAirzenPointsService) {
		memberService = theMemberService;
		earnPointsService = theEarnPointsService;
		airzenPointsService = theAirzenPointsService;
	}

	@GetMapping("/earnAir")
	public String eairnPointsAir(Model theModel) {

		EarnPointsDTO earnPointsDTO = new EarnPointsDTO();
		theModel.addAttribute("earnPointsDTO", earnPointsDTO);
		return "EarnPointsAir";
	}

	@GetMapping("/earnList")
	public String showSearchForm(Model theModel) {
		return "EarnPointsList";
	}

	@GetMapping("/earnListSearch")
	public String eairnPointsAirList(@RequestParam(value = "memno", required = false) Integer memno, Model model) {

		model.addAttribute("searchMemno", memno);
		List<EarnPointsAir> earnPointsList = earnPointsService.findActivitiesByMemno(memno);

		if (memno == null) {
			model.addAttribute("errorMessage", "Enter Membership No");
			return "EarnPointsList";
		}

		else if (earnPointsList != null && !earnPointsList.isEmpty()) {
			model.addAttribute("earnPointsList", earnPointsList);
		}

		else {
			model.addAttribute("errorMessage", "Member does not exists in the system");
		}

		return "EarnPointsList";

	}

	@GetMapping("/earnAirSearch")
	public String earnAirSearch(@RequestParam(value = "memno", required = false) Integer memno, Model model) {

		if (memno == null) {
			model.addAttribute("errorMessage", "Enter Membership Number");
			model.addAttribute("earnPointsDTO", new EarnPointsDTO());
			return "EarnPointsAir";
		}

		Optional<Member> theMember = memberService.findMemberById(memno);

		if (theMember.isPresent()) {

			Member mMember = theMember.get();
			EarnPointsDTO earnPointsDTO = new EarnPointsDTO();

			earnPointsDTO.setMemno(mMember.getId());
			earnPointsDTO.setFirstname(mMember.getFirstname());
			earnPointsDTO.setSurname(mMember.getSurname());

			model.addAttribute("earnPointsDTO", earnPointsDTO);
			return "EarnPointsAir";
		}

		else {
			model.addAttribute("errorMessage", "Member does not exists in the system");
			model.addAttribute("earnPointsDTO", new EarnPointsDTO());
			return "EarnPointsAir";
		}
	}

	@PostMapping("/saveEarn")
	public String saveEarn(@Valid @ModelAttribute("earnPointsDTO") EarnPointsDTO earnPointsDTO, BindingResult result,
			Model model) {

		EarnPointsAir earnPointsAir = new EarnPointsAir();

		if (result.hasErrors()) {
			System.out.println(result);
			return "EarnPointsAir";
		}

		try {

			LocalDate currentDate = LocalDate.now();
			if (earnPointsDTO.getFltdat().isAfter(currentDate)) {
				BeanUtils.copyProperties(earnPointsDTO, earnPointsAir);
				earnPointsAir.setStatus("Rejected");
				earnPointsAir.setRejrsn("Flight Date is a future date");
				earnPointsAir.setPntval(0);
			}

			else {

				BeanUtils.copyProperties(earnPointsDTO, earnPointsAir);

				int points = airzenPointsService.calculatePoints(earnPointsDTO.getOrg(), earnPointsDTO.getDest());
				MemberPointDetails pointDetails = earnPointsService
						.findMemberPointDetailsById(earnPointsDTO.getMemno());
				pointDetails.setId(earnPointsDTO.getMemno());
				pointDetails.setAznpnt(points);
				pointDetails.setTtlpnt(pointDetails.getTtlpnt() + points);
				pointDetails.setLngcpn(pointDetails.getLngcpn() + 1);
				pointDetails.setFltcnt(pointDetails.getFltcnt() + 1);

				int totalPoints = pointDetails.getTtlpnt();
				int flightCount = pointDetails.getFltcnt();

				Optional<MemberTier> nextTier = earnPointsService.evaluateTier(totalPoints, flightCount);

				Optional<Member> tierDetails = memberService.findMemberById(earnPointsDTO.getMemno());
				Member memberTier = tierDetails.get();

				if (nextTier.isPresent()) {
					memberTier.setTier(nextTier.get().getTierName());
					memberService.save(memberTier);
				}

				earnPointsService.savePointDetails(pointDetails);
				earnPointsAir.setStatus("Processed");
				earnPointsAir.setPntval(points);

			}

			earnPointsService.save(earnPointsAir);

			return "redirect:/airzen/earn/viewEarn?actnum=" + earnPointsAir.getActnum();
		}

		catch (Exception e) {
			model.addAttribute("errorMessage", "Unexpected Server Error");
			return "EarnPointsAir";
		}
	}

	

	@GetMapping("/viewEarn")
	public String viewEarn(@RequestParam(value = "actnum", required = false) Integer actnum, Model model) {

		if (actnum == null) {
			model.addAttribute("errorMessage", "Enter Membership Number");
			model.addAttribute("earnPointsDTO", new EarnPointsDTO());
			return "EarnPointsDetailsAir";
		}

		Optional<EarnPointsAir> theMember = earnPointsService.findMemberById(actnum);

		if (theMember.isPresent()) {

			EarnPointsAir epAir = theMember.get();
			MemberPointDetails pointDetails = earnPointsService.findMemberPointDetailsById(epAir.getMemno());
			Optional<Member> tierDetails = memberService.findMemberById(epAir.getMemno());

			Member memberTier = tierDetails.get();
			EarnPointsDTO earnPointsDTO = new EarnPointsDTO();

			BeanUtils.copyProperties(epAir, earnPointsDTO);
			BeanUtils.copyProperties(pointDetails, earnPointsDTO);

			LocalDate flightDate = epAir.getFltdat();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			String formattedDate = flightDate.format(formatter);
			earnPointsDTO.setFormattedDate(formattedDate);

			String currentTier = memberTier.getTier();
			earnPointsDTO.setTier(currentTier);

			Optional<MemberTier> toAttainTier = earnPointsService.evaluatetoAttainTier(currentTier);

			if (toAttainTier.isPresent()) {
				earnPointsDTO.setNextTier(toAttainTier.get().getTierName());
				int nextTierPoints = toAttainTier.get().getTierttlpnt();
				int pointsNeeded = Math.max(0, nextTierPoints - pointDetails.getTtlpnt());
				int nextTierFltCnt = toAttainTier.get().getTierfltcnt();
				int fltCntNeeded = Math.max(0, nextTierFltCnt - pointDetails.getFltcnt());
				earnPointsDTO.setTgtPnt(pointsNeeded);
				earnPointsDTO.setTierttlpnt(nextTierPoints);
				earnPointsDTO.setTgtFltCnt(fltCntNeeded);
				earnPointsDTO.setTierfltcnt(nextTierFltCnt);
			}

			model.addAttribute("earnPointsDTO", earnPointsDTO);

			return "EarnPointsDetailsAir";
		}

		else {
			model.addAttribute("errorMessage", "Member does not exists in the system");
			model.addAttribute("earnPointsDTO", new EarnPointsDTO());
			return "EarnPointsDetailsAir";
		}
	}

}
