package com.geo.airzen.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geo.airzen.dto.EarnPointsDTO;
import com.geo.airzen.dto.MemberDTO;
import com.geo.airzen.entity.Member;
import com.geo.airzen.entity.MemberContactInfo;
import com.geo.airzen.entity.MemberDocumentInfo;
import com.geo.airzen.entity.MemberPointDetails;
import com.geo.airzen.entity.MemberPreferences;
import com.geo.airzen.entity.MemberTier;
import com.geo.airzen.entity.Preferences;
import com.geo.airzen.service.EarnPointsService;
import com.geo.airzen.service.MemberContactService;
import com.geo.airzen.service.MemberService;

import jakarta.servlet.http.HttpSession;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

@Controller
@RequestMapping("/airzen")
public class MemberController {

	private MemberService memberService;

	private MemberContactService memberContactService;

	private EarnPointsService earnPointsService;

	public MemberController(MemberService theMemberService, MemberContactService theMemberContactService,
			EarnPointsService earnPointsService) {
		memberService = theMemberService;
		memberContactService = theMemberContactService;
		this.earnPointsService = earnPointsService;
	}

	@GetMapping("/home")
	public String home(Model theModel) {

		MemberDTO theMemberDTO = new MemberDTO();
		theModel.addAttribute("memberDTO", theMemberDTO);
		return "home";
	}

	@PostMapping("/save")
	public String saveMember(@Valid @ModelAttribute("memberDTO") MemberDTO theMemberDTO, BindingResult result,
			Model model, HttpSession session) {

		Member theMember = new Member();
		MemberContactInfo theMemberContactInfo = new MemberContactInfo();

		if (result.hasErrors()) {
			System.out.println(result);
			return "home";
		}

		if ((theMemberDTO.getTitle().equals("Mrs") && theMemberDTO.getGender().equals("Male"))
				|| (theMemberDTO.getTitle().equals("Mr") && theMemberDTO.getGender().equals("Female"))
				|| (theMemberDTO.getTitle().equals("Ms") && theMemberDTO.getGender().equals("Male"))) {
			model.addAttribute("errorMessage", "Title and Gender does not match");
			model.addAttribute("memberDTO", theMemberDTO);
			return "home";
		}

		BeanUtils.copyProperties(theMemberDTO, theMember);
		BeanUtils.copyProperties(theMemberDTO, theMemberContactInfo);

		String dobText = theMemberDTO.getDob();
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		theMember.setDob(LocalDate.parse(dobText, inputFormatter));
		
		LocalDate currentDate = LocalDate.now();
		theMember.setEnrdat(currentDate);

		session.setAttribute("success", true);

		// save the member
		memberService.save(theMember);
		memberContactService.save(theMemberContactInfo);

		// Preference Section
		MemberPreferences memberPreferences = memberService.findPreferencesByMemid(theMember.getId());
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			if (memberPreferences != null) {
				String preferencesJson = objectMapper.writeValueAsString(theMemberDTO.getPreferences());
				memberPreferences.setPreferences(preferencesJson);
				memberService.saveMemberPreferences(memberPreferences);
			} else if (memberPreferences == null) {
				MemberPreferences newMemberPreference = new MemberPreferences();
				newMemberPreference.setMemid(theMember.getId());
				String preferencesJson = objectMapper.writeValueAsString(theMemberDTO.getPreferences());
				newMemberPreference.setPreferences(preferencesJson);
				memberService.saveMemberPreferences(newMemberPreference);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "Error saving preferences");
			return "home";
		}

		// Document Section
		List<MemberDocumentInfo> documentInfos = (List<MemberDocumentInfo>) session.getAttribute("tempDocumentInfos");

		if (documentInfos != null) {
			for (MemberDocumentInfo documentInfo : documentInfos) {
				documentInfo.setMemid(theMember.getId());
				memberService.saveDoc(documentInfo);
			}
			session.removeAttribute("tempDocumentInfos");
		}

		// use a redirect to prevent duplicate submissions
		return "redirect:/airzen/searchMember?id=" + theMember.getId();

	}

	@PostMapping("/upload")
	public String saveDoc(@ModelAttribute("memberDTO") MemberDTO theMemberDTO, BindingResult result, Model model,
			HttpSession session) {

		List<MultipartFile> files = theMemberDTO.getData();
		List<String> docTypes = theMemberDTO.getDocType();

		List<MemberDocumentInfo> documentInfos = new ArrayList<>();

		try {
			for (int i = 0; i < files.size(); i++) {
				MultipartFile file = files.get(i);
				String docType = docTypes.get(i);
				MemberDocumentInfo theDocumentInfo = new MemberDocumentInfo();
				theDocumentInfo.setData(file.getBytes());
				theDocumentInfo.setDocType(docType);
				documentInfos.add(theDocumentInfo);
			}

			session.setAttribute("tempDocumentInfos", documentInfos);
			return "home";
		} catch (Exception e) {
			model.addAttribute("errorMessage", "Document Upload Failed. Please Try Again");
			return "home";
		}

	}

	@GetMapping("/search")
	public String showSearchForm(Model theModel) {

		MemberDTO theMemberDTO = new MemberDTO();
		Preferences preferences = new Preferences();
		theModel.addAttribute("preferences", preferences);
		theModel.addAttribute("memberDTO", theMemberDTO);
		return "ManageMember";
	}

	@GetMapping("/searchMember")
	public String searchUser(@RequestParam(value = "id", required = false) Integer id, HttpSession session,
			Model model) {

		if (id == null) {
			model.addAttribute("errorMessage", "Enter Membership Number");
			model.addAttribute("memberDTO", new MemberDTO());
			return "ManageMember";
		}

		Boolean success = (Boolean) session.getAttribute("success");
		if (success != null && success) {
			model.addAttribute("showToast", true);
			session.removeAttribute("success");
		}

		Optional<Member> theMember = memberService.findMemberById(id);

		Optional<MemberContactInfo> theMemberContactInfo = memberContactService.findMemberById(id);

		List<MemberDocumentInfo> docInfos = memberService.findDocumentsByMemid(id);

		if (theMember.isPresent() && theMemberContactInfo.isPresent()) {

			Member mMember = theMember.get();
			MemberContactInfo mMemberContactInfo = theMemberContactInfo.get();
			MemberDTO memberDTO = new MemberDTO();

			BeanUtils.copyProperties(mMember, memberDTO);
			BeanUtils.copyProperties(mMemberContactInfo, memberDTO);

			LocalDate dateOfBirth = mMember.getDob();
			LocalDate enrollmentDate = mMember.getEnrdat();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			String formattedDate = dateOfBirth.format(formatter);
			String formattedEnrDat = enrollmentDate.format(formatter);
			memberDTO.setDob(formattedDate);
			memberDTO.setEnrdat(formattedEnrDat);

			// Preference Section
			MemberPreferences memberPreferences = memberService.findPreferencesByMemid(id);

			ObjectMapper objectMapper = new ObjectMapper();
			Preferences preferences = null;
			try {
				preferences = objectMapper.readValue(memberPreferences.getPreferences(), Preferences.class);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

			memberDTO.setPreferences(preferences);
			model.addAttribute("preferences", preferences);

			model.addAttribute("docInfos", docInfos);

			model.addAttribute("memberDTO", memberDTO);
			return "ManageMember";
		}

		else {
			model.addAttribute("errorMessage", "Member does not exists in the system");
			model.addAttribute("memberDTO", new MemberDTO());
			return "ManageMember";
		}
	}

	@GetMapping("/path/to/documents/{docId}")
	public ResponseEntity<ByteArrayResource> downloadDocument(@PathVariable("docId") Integer docId) {
		MemberDocumentInfo document = memberService.getDocumentById(docId);
		if (document == null) {
			return ResponseEntity.notFound().build();
		}

		Optional<Member> theMember = memberService.findMemberById(document.getMemid());
		Member memName = theMember.get();

		String fileName = document.getDocType() + "_" + memName.getFirstname() + ".pdf";

		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/octet-stream"))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
				.body(new ByteArrayResource(document.getData()));
	}

	@DeleteMapping("/delete/document/{docId}")
	public ResponseEntity<String> deleteDocument(@PathVariable("docId") Integer docId) {
		boolean isDeleted = memberService.deleteDocumentById(docId);
		if (isDeleted) {
			return ResponseEntity.ok("Document deleted successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found");
		}
	}
	

	@GetMapping("/membersummary")
	public String memberSummary(Model theModel) {
		MemberDTO theMemberDTO = new MemberDTO();
		theModel.addAttribute("memberDTO", theMemberDTO);
		return "MemberSummary";
	}

	@GetMapping("/viewsummary")
	public String memberSummaryDetails(@RequestParam(value = "id", required = false) Integer id, Model theModel) {

		if (id == null) {
			theModel.addAttribute("errorMessage", "Enter Membership Number");
			theModel.addAttribute("memberDTO", new MemberDTO());
			return "MemberSummary";
		}

		Optional<Member> theMember = memberService.findMemberById(id);

		if (theMember.isPresent()) {

			Member mMember = theMember.get();

			MemberDTO memberDTO = new MemberDTO();

			MemberPointDetails pointDetails = earnPointsService.findMemberPointDetailsById(mMember.getId());
			Optional<Member> tierDetails = memberService.findMemberById(mMember.getId());

			if (pointDetails != null && tierDetails.isPresent()) {

				Member memberTier = tierDetails.get();

				BeanUtils.copyProperties(pointDetails, memberDTO);

				String currentTier = memberTier.getTier();
				memberDTO.setTier(currentTier);

				Optional<MemberTier> toAttainTier = earnPointsService.evaluatetoAttainTier(currentTier);

				if (toAttainTier.isPresent()) {
					memberDTO.setNextTier(toAttainTier.get().getTierName());
					int nextTierPoints = toAttainTier.get().getTierttlpnt();
					int pointsNeeded = Math.max(0, nextTierPoints - pointDetails.getTtlpnt());
					int nextTierFltCnt = toAttainTier.get().getTierfltcnt();
					int fltCntNeeded = Math.max(0, nextTierFltCnt - pointDetails.getFltcnt());
					memberDTO.setTgtPnt(pointsNeeded);
					memberDTO.setTierttlpnt(nextTierPoints);
					memberDTO.setTgtFltCnt(fltCntNeeded);
					memberDTO.setTierfltcnt(nextTierFltCnt);
				}

			}

			theModel.addAttribute("memberDTO", memberDTO);
			return "MemberSummary";

		}

		else {
			theModel.addAttribute("errorMessage", "Member does not exists in the system");
			theModel.addAttribute("memberDTO", new MemberDTO());
			return "MemberSummary";
		}

	}

}