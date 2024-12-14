package com.geo.airzen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geo.airzen.dao.MemberDocumentRepository;
import com.geo.airzen.dao.MemberPreferenceRepository;
import com.geo.airzen.dao.MemberRepository;
import com.geo.airzen.entity.Member;
import com.geo.airzen.entity.MemberDocumentInfo;
import com.geo.airzen.entity.MemberPreferences;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;
    
    private MemberDocumentRepository memberDocumentRepository;
    
    private MemberPreferenceRepository memberPreferenceRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository theMemberRepository, MemberDocumentRepository theMemberDocumentRepository, MemberPreferenceRepository theMemberPreferenceRepository) {
        memberRepository = theMemberRepository;
        memberDocumentRepository = theMemberDocumentRepository;
        memberPreferenceRepository =  theMemberPreferenceRepository;
    }

    @Override
    public Member save(Member theMember) {
        return memberRepository.save(theMember);
    }
    
    public Optional<Member> findMemberById(Integer id) {
        return memberRepository.findById(id);
    
    }

	@Override
	public MemberDocumentInfo saveDoc(MemberDocumentInfo theDocumentInfo) {
		return memberDocumentRepository.save(theDocumentInfo);
	}

	@Override
	public MemberPreferences saveMemberPreferences(MemberPreferences theMemberPreferences) {
		return memberPreferenceRepository.save(theMemberPreferences);
	}

	@Override
	public MemberPreferences findPreferencesByMemid(Integer memid) {
		return memberPreferenceRepository.findByMemid(memid);
	}

	@Override
	public List<MemberDocumentInfo> findDocumentsByMemid(Integer memid) {
		return memberDocumentRepository.findByMemid(memid);
	}

	@Override
	public MemberDocumentInfo getDocumentById(Integer docId) {
		return memberDocumentRepository.findById(docId).orElse(null);
	}

	@Override
	public boolean deleteDocumentById(Integer docId) {
		try {
            memberDocumentRepository.deleteById(docId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

	}
    
}



