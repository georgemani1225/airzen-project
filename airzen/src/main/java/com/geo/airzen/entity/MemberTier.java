package com.geo.airzen.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "memtier")
public class MemberTier {

	@Id
	@Column(name = "tierid")
	private Integer tierId;

	@Column(name = "tiername")
	private String tierName;
	
	@Column(name = "tierttlpnt")
	private int tierttlpnt;
	
	@Column(name = "tierfltcnt")
	private int tierfltcnt;
	
	public MemberTier() {

    }

	public MemberTier(Integer tierId, String tierName, int tierttlpnt, int tierfltcnt) {
		super();
		this.tierId = tierId;
		this.tierName = tierName;
		this.tierttlpnt = tierttlpnt;
		this.tierfltcnt = tierfltcnt;
	}

	public Integer getTierId() {
		return tierId;
	}

	public void setTierId(Integer tierId) {
		this.tierId = tierId;
	}

	public String getTierName() {
		return tierName;
	}

	public void setTierName(String tierName) {
		this.tierName = tierName;
	}

	public int getTierttlpnt() {
		return tierttlpnt;
	}

	public void setTierttlpnt(int tierttlpnt) {
		this.tierttlpnt = tierttlpnt;
	}

	public int getTierfltcnt() {
		return tierfltcnt;
	}

	public void setTierfltcnt(int tierfltcnt) {
		this.tierfltcnt = tierfltcnt;
	}
	
	

}
