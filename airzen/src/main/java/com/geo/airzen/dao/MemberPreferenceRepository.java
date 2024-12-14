package com.geo.airzen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geo.airzen.entity.MemberPreferences;

public interface MemberPreferenceRepository extends JpaRepository<MemberPreferences, Integer> {
	
	MemberPreferences findByMemid(Integer memid);

}
