package com.geo.airzen.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="mempref")
public class MemberPreferences {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prfidr")
	private Integer prfidr;
	
	@Column(name="memid")
    private Integer memid;
	
	@Column(name = "preferences")
    private String preferences;
	
	public MemberPreferences() {
	
	}

	public MemberPreferences(Integer prfidr, Integer memid, String preferences) {
		super();
		this.prfidr = prfidr;
		this.memid = memid;
		this.preferences = preferences;
	}

	public Integer getPrfidr() {
		return prfidr;
	}

	public Integer getMemid() {
		return memid;
	}

	public String getPreferences() {
		return preferences;
	}

	public void setPrfidr(Integer prfidr) {
		this.prfidr = prfidr;
	}

	public void setMemid(Integer memid) {
		this.memid = memid;
	}

	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}


}
