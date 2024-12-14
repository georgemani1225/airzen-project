package com.geo.airzen.service;

import java.util.List;
import java.util.Optional;

import com.geo.airzen.entity.Member;
import com.geo.airzen.entity.MemberDocumentInfo;
import com.geo.airzen.entity.MemberPreferences;

public interface MemberService {

	Member save(Member theMember);

	Optional<Member> findMemberById(Integer id);

	MemberDocumentInfo saveDoc(MemberDocumentInfo theDocumentInfo);
	
	List<MemberDocumentInfo> findDocumentsByMemid(Integer memid);
	
	MemberDocumentInfo getDocumentById(Integer docId);
	
	boolean deleteDocumentById(Integer docId);
	
	MemberPreferences saveMemberPreferences(MemberPreferences theMemberPreferences);
	
	MemberPreferences findPreferencesByMemid(Integer memid);
}
