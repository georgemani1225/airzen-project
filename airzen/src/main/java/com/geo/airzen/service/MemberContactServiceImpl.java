package com.geo.airzen.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geo.airzen.dao.MemberContactRepository;
import com.geo.airzen.entity.MemberContactInfo;

@Service
public class MemberContactServiceImpl implements MemberContactService {

    private MemberContactRepository memberContactRepository;

    @Autowired
    public MemberContactServiceImpl(MemberContactRepository theMemberContactRepository) {
        memberContactRepository = theMemberContactRepository;
    }

    @Override
    public MemberContactInfo save(MemberContactInfo theMemberContactInfo) {
        return memberContactRepository.save(theMemberContactInfo);
    }
    
    public Optional<MemberContactInfo> findMemberById(Integer id) {
        return memberContactRepository.findById(id);
    
    }
    
    

}



