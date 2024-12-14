package com.geo.airzen.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.geo.airzen.entity.MemberTier;

public interface MemberTierRepository extends JpaRepository<MemberTier, Integer> {
	
	@Query("select t from MemberTier t where t.tierttlpnt <= :totalPoints and t.tierfltcnt <= :flightCount order by t.tierId desc limit 1")
	Optional<MemberTier> findTier(int totalPoints, int flightCount);
	
	@Query("select t from MemberTier t where t.tierId > (select t2.tierId from MemberTier t2 where t2.tierName = :currentTierName) order by t.tierId asc limit 1")
	Optional<MemberTier> findToAttainTier(String currentTierName);

}
