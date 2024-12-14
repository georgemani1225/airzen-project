package com.geo.airzen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geo.airzen.dao.AirzenPointsRepository;
import com.geo.airzen.entity.AirzenPoints;

@Service
public class AirzenPointsServiceImpl implements AirzenPointsService {
	
	@Autowired
	private AirzenPointsRepository airzenPointsRepository;

	@Override
	public int calculatePoints(String org, String dest) {
		AirzenPoints airzenPoints = airzenPointsRepository.findByOrgAndDest(org, dest);
		
		if(airzenPoints != null) {
			return airzenPoints.getPnt();
		}
		
		return 0;
		
	}

}
