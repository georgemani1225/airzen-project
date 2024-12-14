package com.geo.airzen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geo.airzen.entity.PartnerMaster;

public interface PartnerRepository extends JpaRepository<PartnerMaster, String> {

}
