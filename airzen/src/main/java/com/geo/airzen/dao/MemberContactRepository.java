package com.geo.airzen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geo.airzen.entity.MemberContactInfo;

public interface MemberContactRepository extends JpaRepository<MemberContactInfo, Integer> {

}
