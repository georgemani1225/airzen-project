package com.geo.airzen.controller;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geo.airzen.dto.RedeemPointsDTO;
import com.geo.airzen.entity.EarnPointsAir;
import com.geo.airzen.entity.Member;
import com.geo.airzen.entity.MemberPointDetails;
import com.geo.airzen.entity.MemberTier;
import com.geo.airzen.entity.PartnerMaster;
import com.geo.airzen.entity.RedeemPoints;
import com.geo.airzen.service.EarnPointsService;
import com.geo.airzen.service.MemberService;
import com.geo.airzen.service.RedeemPointsService;

@Controller
@RequestMapping("/airzen/redeem")
public class RedemptionController {

	private MemberService memberService;

	private EarnPointsService earnPointsService;

	private RedeemPointsService redeemPointsService;

	public RedemptionController(MemberService memberService, EarnPointsService earnPointsService,
			RedeemPointsService redeemPointsService) {
		this.memberService = memberService;
		this.earnPointsService = earnPointsService;
		this.redeemPointsService = redeemPointsService;
	}

	@GetMapping("/redeemPoints")
	public String eairnPointsAir(Model theModel) {
		RedeemPointsDTO redeemPointsDTO = new RedeemPointsDTO();
		List<PartnerMaster> partners = redeemPointsService.getAllPartners();
		theModel.addAttribute("partners", partners);
		theModel.addAttribute("redeemPointsDTO", redeemPointsDTO);
		return "AirRedeem";
	}

	@GetMapping("/memberSearch")
	public String redeemMemberSearch(@RequestParam(value = "memno", required = false) Integer memno, Model model) {

		if (memno == null) {
			model.addAttribute("errorMessage", "Enter Membership Number");
			model.addAttribute("redeemPointsDTO", new RedeemPointsDTO());
			return "AirRedeem";
		}

		Optional<Member> theMember = memberService.findMemberById(memno);

		if (theMember.isPresent()) {

			Member mMember = theMember.get();
			RedeemPointsDTO redeemPointsDTO = new RedeemPointsDTO();

			MemberPointDetails pointDetails = earnPointsService.findMemberPointDetailsById(mMember.getId());

			redeemPointsDTO.setPnts(pointDetails.getTtlpnt());

			redeemPointsDTO.setMemno(mMember.getId());
			redeemPointsDTO.setFirstname(mMember.getFirstname());
			redeemPointsDTO.setSurname(mMember.getSurname());

			List<PartnerMaster> partners = redeemPointsService.getAllPartners();
			model.addAttribute("partners", partners);

			model.addAttribute("redeemPointsDTO", redeemPointsDTO);
			return "AirRedeem";
		}

		else {
			model.addAttribute("errorMessage", "Member does not exists in the system");
			model.addAttribute("redeemPointsDTO", new RedeemPointsDTO());
			return "AirRedeem";
		}
	}

	@GetMapping("/calculatePoints")
	@ResponseBody
	public int calculatePoints(@RequestParam("partnerCode") String partnerCode, @RequestParam("days") int days,
			@RequestParam("guests") int guests) {

		int pointsPerDay = redeemPointsService.getRedemptionPointsByPartnerCode(partnerCode);
		int totalPoints = pointsPerDay * days * guests;
		return totalPoints;
	}

	@GetMapping("/partnerCode")
	public ResponseEntity<Optional<PartnerMaster>> fetchPartnerName(@RequestParam("partnerCode") String partnerCode) {
		Optional<PartnerMaster> partnerName = redeemPointsService.getPartnerName(partnerCode);
		if (partnerName.isPresent()) {
			return ResponseEntity.ok(partnerName);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/saveRedeem")
	public String saveRedeem(@Valid @ModelAttribute("redeemPointsDTO") RedeemPointsDTO redeemPointsDTO,
			BindingResult result, Model model) {

		RedeemPoints redeemPoints = new RedeemPoints();
		List<PartnerMaster> partners = redeemPointsService.getAllPartners();

		if (result.hasErrors()) {
			System.out.println(result);
			model.addAttribute("partners", partners);
			return "AirRedeem";
		}

		try {

			LocalDate currentDate = LocalDate.now();
			MemberPointDetails pointDetails = earnPointsService.findMemberPointDetailsById(redeemPointsDTO.getMemno());
			int rdmPoints = redeemPointsDTO.getttlrdmpnts();

			if (redeemPointsDTO.getChkindat().isBefore(currentDate)) {
				BeanUtils.copyProperties(redeemPointsDTO, redeemPoints);
				redeemPoints.setStatus("Rejected");
				redeemPoints.setRejrsn("Check-In date is a past date");
				redeemPoints.setRdmpntval(0);
			}

			else if (rdmPoints > pointDetails.getAznpnt()) {
				BeanUtils.copyProperties(redeemPointsDTO, redeemPoints);
				redeemPoints.setStatus("Rejected");
				redeemPoints.setRejrsn("Insufficient Account Balance");
				redeemPoints.setRdmpntval(0);
			}

			else {

				BeanUtils.copyProperties(redeemPointsDTO, redeemPoints);
				pointDetails.setAznpnt(pointDetails.getAznpnt() - rdmPoints);
				pointDetails.setTtlpnt(pointDetails.getTtlpnt() - rdmPoints);

				Optional<Member> tierDetails = memberService.findMemberById(redeemPointsDTO.getMemno());
				Member memberTier = tierDetails.get();

				int totalPoints = pointDetails.getTtlpnt();
				int flightCount = pointDetails.getFltcnt();

				Optional<MemberTier> nextTier = earnPointsService.evaluateTier(totalPoints, flightCount);

				if (nextTier.isPresent()) {
					memberTier.setTier(nextTier.get().getTierName());
					memberService.save(memberTier);
				}

				String ptrcod = redeemPointsDTO.getPtrcod();
				
				SecureRandom secureRandom = new SecureRandom();
				StringBuilder code1 = new StringBuilder();
				StringBuilder code2 = new StringBuilder();
				for (int i = 0; i < 4; i++) {
		            code1.append(secureRandom.nextInt(10));
		            code2.append(secureRandom.nextInt(10));
		        }
				
				String redeemCode1 = code1.toString();
				String redeemCode2 = code2.toString();
				
				String rdmcod = ptrcod.substring(0, 5) + "-" + redeemCode1 + "-" + redeemCode2;
				redeemPoints.setRdmcod(rdmcod);

				earnPointsService.savePointDetails(pointDetails);
				redeemPoints.setStatus("Processed");
				redeemPoints.setRdmpntval(rdmPoints);

			}

			redeemPointsService.save(redeemPoints);

			return "redirect:/airzen/redeem/viewRedeem?rdmid=" + redeemPoints.getRdmid();

		} catch (Exception e) {
			model.addAttribute("errorMessage", "Unexpected Server Error");
			return "AirRedeem";
		}

	}

	@GetMapping("/viewRedeem")
	public String viewEarn(@RequestParam(value = "rdmid", required = false) Integer rdmid, Model model) {

		if (rdmid == null) {
			model.addAttribute("errorMessage", "Enter Membership Number");
			model.addAttribute("redeemPointsDTO", new RedeemPointsDTO());
			return "AirRedeemDetails";
		}

		Optional<RedeemPoints> theMember = redeemPointsService.findMemberById(rdmid);

		if (theMember.isPresent()) {

			RedeemPoints rdmAir = theMember.get();
			MemberPointDetails pointDetails = earnPointsService.findMemberPointDetailsById(rdmAir.getMemno());
			Optional<Member> tierDetails = memberService.findMemberById(rdmAir.getMemno());

			Member memberTier = tierDetails.get();
			RedeemPointsDTO redeemPointsDTO = new RedeemPointsDTO();

			BeanUtils.copyProperties(rdmAir, redeemPointsDTO);
			BeanUtils.copyProperties(pointDetails, redeemPointsDTO);

			LocalDate checkInDate = rdmAir.getChkindat();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			String formattedDate = checkInDate.format(formatter);
			redeemPointsDTO.setFormattedDate(formattedDate);

			String currentTier = memberTier.getTier();
			redeemPointsDTO.setTier(currentTier);

			Optional<MemberTier> toAttainTier = earnPointsService.evaluatetoAttainTier(currentTier);

			if (toAttainTier.isPresent()) {
				redeemPointsDTO.setNextTier(toAttainTier.get().getTierName());
				int nextTierPoints = toAttainTier.get().getTierttlpnt();
				int pointsNeeded = Math.max(0, nextTierPoints - pointDetails.getTtlpnt());
				int nextTierFltCnt = toAttainTier.get().getTierfltcnt();
				int fltCntNeeded = Math.max(0, nextTierFltCnt - pointDetails.getFltcnt());
				redeemPointsDTO.setTgtPnt(pointsNeeded);
				redeemPointsDTO.setTierttlpnt(nextTierPoints);
				redeemPointsDTO.setTgtFltCnt(fltCntNeeded);
				redeemPointsDTO.setTierfltcnt(nextTierFltCnt);
			}

			model.addAttribute("redeemPointsDTO", redeemPointsDTO);

			return "AirRedeemDetails";
		}

		else {
			model.addAttribute("errorMessage", "Member does not exists in the system");
			model.addAttribute("redeemPointsDTO", new RedeemPointsDTO());
			return "AirRedeemDetails";
		}
	}

	@GetMapping("/redeemList")
	public String showSearchForm(Model theModel) {
		return "RedeemPointsList";
	}

	@GetMapping("/redeemListSearch")
	public String eairnPointsAirList(@RequestParam(value = "memno", required = false) Integer memno, Model model) {

		model.addAttribute("searchMemno", memno);
		List<RedeemPoints> redeemPointsList = redeemPointsService.findRedemptionActivities(memno);

		if (memno == null) {
			model.addAttribute("errorMessage", "Enter Membership No");
			return "RedeemPointsList";
		}

		else if (redeemPointsList != null && !redeemPointsList.isEmpty()) {
			model.addAttribute("redeemPointsList", redeemPointsList);
		}

		else {
			model.addAttribute("errorMessage", "Member does not exists in the system");
		}

		return "RedeemPointsList";

	}

}
