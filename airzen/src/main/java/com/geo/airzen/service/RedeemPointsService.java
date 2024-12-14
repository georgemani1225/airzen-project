package com.geo.airzen.service;

import java.util.List;
import java.util.Optional;

import com.geo.airzen.entity.EarnPointsAir;
import com.geo.airzen.entity.PartnerMaster;
import com.geo.airzen.entity.RedeemPoints;

public interface RedeemPointsService {
	
	int getRedemptionPointsByPartnerCode(String ptrcod);
	
	RedeemPoints save(RedeemPoints redeemPoints);
	
	Optional<PartnerMaster> getPartnerName(String ptrcod);
	
	List<PartnerMaster> getAllPartners();
	
	Optional<RedeemPoints> findMemberById(Integer rdmid);
	
	List<RedeemPoints> findRedemptionActivities(Integer memno);
	
}
