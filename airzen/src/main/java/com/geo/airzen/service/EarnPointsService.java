package com.geo.airzen.service;

import java.util.List;
import java.util.Optional;

import com.geo.airzen.entity.EarnPointsAir;
import com.geo.airzen.entity.MemberPointDetails;
import com.geo.airzen.entity.MemberTier;

public interface EarnPointsService {
	
	EarnPointsAir save(EarnPointsAir theEarnPointsAir);
	
	Optional<EarnPointsAir> findMemberById(Integer actnum);
	
	MemberPointDetails savePointDetails(MemberPointDetails thePointDetails);
	
	MemberPointDetails findMemberPointDetailsById(Integer id);
	
	Optional<MemberTier> evaluateTier(int totalPoints, int flightCount);
	
	Optional<MemberTier> evaluatetoAttainTier(String currentTierName);
	
	List<EarnPointsAir> findActivitiesByMemno(Integer memno);

}
