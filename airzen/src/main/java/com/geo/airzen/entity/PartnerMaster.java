package com.geo.airzen.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ptrmst")
public class PartnerMaster {
	
    @Id
	@Column(name="ptrcod")
    private String ptrcod;
    
    @Column(name="ptrnam")
    private String ptrnam;

	public PartnerMaster() {
		
	}

	public PartnerMaster(String ptrcod, String ptrnam) {
		super();
		this.ptrcod = ptrcod;
		this.ptrnam = ptrnam;
	}

	public String getPtrcod() {
		return ptrcod;
	}

	public String getPtrnam() {
		return ptrnam;
	}

	public void setPtrcod(String ptrcod) {
		this.ptrcod = ptrcod;
	}

	public void setPtrnam(String ptrnam) {
		this.ptrnam = ptrnam;
	}

}