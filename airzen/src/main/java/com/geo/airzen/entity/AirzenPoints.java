package com.geo.airzen.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="aznpnts")
public class AirzenPoints {
	
	@Id
    @Column(name="pntid")
    private Integer pntid;
	
	@Column(name="org")
    private String org;
    
    @Column(name="dest")
    private String dest;
    
    @Column(name="pnt")
    private Integer pnt;
    
    // define constructors
    public AirzenPoints() {

    }

	public AirzenPoints(Integer pntid, String org, String dest, Integer pnt) {
		super();
		this.pntid = pntid;
		this.org = org;
		this.dest = dest;
		this.pnt = pnt;
	}

	public Integer getPntid() {
		return pntid;
	}

	public void setPntid(Integer pntid) {
		this.pntid = pntid;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public Integer getPnt() {
		return pnt;
	}

	public void setPnt(Integer pnt) {
		this.pnt = pnt;
	}
    

}
