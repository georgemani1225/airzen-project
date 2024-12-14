package com.geo.airzen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.geo.airzen.dao.MemberTierRepository;
import com.geo.airzen.dao.PartnerPointsRepository;
import com.geo.airzen.dao.PartnerRepository;
import com.geo.airzen.dao.RedeemPointsRepository;
import com.geo.airzen.entity.MemberTier;
import com.geo.airzen.entity.PartnerMaster;
import com.geo.airzen.entity.PartnerPoints;
import com.geo.airzen.entity.RedeemPoints;

@Service
public class RedeemPointsServiceImpl implements RedeemPointsService {
	
	private PartnerPointsRepository partnerPointsRepository;
	
	private RedeemPointsRepository redeemPointsRepository;
	
	private PartnerRepository partnerRepository;

	public RedeemPointsServiceImpl(PartnerPointsRepository partnerPointsRepository, RedeemPointsRepository redeemPointsRepository, PartnerRepository partnerRepository) {
		this.partnerPointsRepository = partnerPointsRepository;
		this.redeemPointsRepository = redeemPointsRepository;
		this.partnerRepository = partnerRepository;
	}

	@Override
	public int getRedemptionPointsByPartnerCode(String ptrcod) {

		Optional<PartnerPoints> partnerPoints =  partnerPointsRepository.findById(ptrcod);
		if (partnerPoints.isPresent()) {
			PartnerPoints partnerPointsData = partnerPoints.get();
			return partnerPointsData.getRdmpnts();
		}
		
		return 0;
	}

	@Override
	public RedeemPoints save(RedeemPoints redeemPoints) {
		return redeemPointsRepository.save(redeemPoints);
	}

	@Override
	public Optional<PartnerMaster> getPartnerName(String ptrcod) {
		return partnerRepository.findById(ptrcod);
		
	}

	@Override
	public List<PartnerMaster> getAllPartners() {
		return partnerRepository.findAll();
	}

	@Override
	public Optional<RedeemPoints> findMemberById(Integer rdmid) {
		return redeemPointsRepository.findById(rdmid);
	}

	@Override
	public List<RedeemPoints> findRedemptionActivities(Integer memno) {
		return redeemPointsRepository.findByMemno(memno);
	}

}
