package com.geo.airzen.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geo.airzen.entity.RedeemPoints;

public interface RedeemPointsRepository extends JpaRepository<RedeemPoints, Integer> {
	
	List<RedeemPoints> findByMemno(Integer memno);

}
