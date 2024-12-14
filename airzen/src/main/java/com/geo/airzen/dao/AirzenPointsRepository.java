package com.geo.airzen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geo.airzen.entity.AirzenPoints;

public interface AirzenPointsRepository extends JpaRepository<AirzenPoints, Long> {
	
	AirzenPoints findByOrgAndDest(String org, String dest);
}
