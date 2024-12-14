package com.geo.airzen.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ptrrdmpnts")
public class PartnerPoints {
	
	@Id
	@Column(name="ptrcod")
    private String ptrcod;
	
	@Column(name="rdmpnts")
    private Integer rdmpnts;

	public PartnerPoints() {
		
	}

	public String getPtrcod() {
		return ptrcod;
	}

	public int getRdmpnts() {
		return rdmpnts;
	}

	public void setPtrcod(String ptrcod) {
		this.ptrcod = ptrcod;
	}

	public void setRdmpnts(int rdmpnts) {
		this.rdmpnts = rdmpnts;
	}
	
	

}
