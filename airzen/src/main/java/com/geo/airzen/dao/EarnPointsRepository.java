package com.geo.airzen.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geo.airzen.entity.EarnPointsAir;

public interface EarnPointsRepository extends JpaRepository<EarnPointsAir, Integer> {
	
	List<EarnPointsAir> findByMemno(Integer memno);

}
