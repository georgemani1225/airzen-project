package com.geo.airzen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geo.airzen.dao.EarnPointsRepository;
import com.geo.airzen.dao.MemberPointDetailsRepository;
import com.geo.airzen.dao.MemberTierRepository;
import com.geo.airzen.entity.EarnPointsAir;
import com.geo.airzen.entity.MemberPointDetails;
import com.geo.airzen.entity.MemberTier;

@Service
public class EarnPointsServiceImpl implements EarnPointsService {
	
	private EarnPointsRepository earnPointsRepository;
	
	private MemberPointDetailsRepository memberPointDetailsRepository;
	
	private MemberTierRepository memberTierRepository;

    @Autowired
    public EarnPointsServiceImpl(EarnPointsRepository theEarnPointsRepository, MemberPointDetailsRepository theMemberPointDetailsRepository, MemberTierRepository theMemberTierRepository) {
    	earnPointsRepository = theEarnPointsRepository;
    	memberPointDetailsRepository = theMemberPointDetailsRepository;
    	memberTierRepository = theMemberTierRepository;
    }

    @Override
    public EarnPointsAir save(EarnPointsAir theEarnPointsAir) {
        return earnPointsRepository.save(theEarnPointsAir);
    }
    
    public Optional<EarnPointsAir> findMemberById(Integer actnum) {
        return earnPointsRepository.findById(actnum);
    
    }

	@Override
	public MemberPointDetails savePointDetails(MemberPointDetails thePointDetails) {
		return memberPointDetailsRepository.save(thePointDetails);
		
	}

	@Override
	public MemberPointDetails findMemberPointDetailsById(Integer id) {
		return memberPointDetailsRepository.findById(id).orElse(new MemberPointDetails(id, 0, 0, 0, 0));
	}
	
	public Optional<MemberTier> evaluateTier(int totalPoints, int flightCount) {
	    return memberTierRepository.findTier(totalPoints, flightCount);
	}


	@Override
	public List<EarnPointsAir> findActivitiesByMemno(Integer memno) {
		return earnPointsRepository.findByMemno(memno);
	}

	@Override
	public Optional<MemberTier> evaluatetoAttainTier(String currentTierName) {
		return memberTierRepository.findToAttainTier(currentTierName);
	}


    

}
