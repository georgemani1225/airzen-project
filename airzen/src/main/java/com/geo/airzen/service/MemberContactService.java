package com.geo.airzen.service;

import java.util.Optional;

import com.geo.airzen.entity.MemberContactInfo;

public interface MemberContactService {

    MemberContactInfo save(MemberContactInfo theMemberContactInfo);

	Optional<MemberContactInfo> findMemberById(Integer id);

}
