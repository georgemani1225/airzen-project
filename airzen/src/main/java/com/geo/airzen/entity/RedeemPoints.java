package com.geo.airzen.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="rdmpnts")
public class RedeemPoints {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rdmid")
    private Integer rdmid;
	
	@Column(name="memno")
	private Integer memno;
	
	@Column(name="firstname")
    private String firstname;
    
    @Column(name="surname")
    private String surname;
    
    @Column(name = "ptrcod")
	private String ptrcod;
    
    @Column(name = "ptrnam")
	private String ptrnam;

    @Column(name = "chkindat")
	private LocalDate chkindat;

    @Column(name = "daycnt")
	private int daycnt;

    @Column(name = "gcnt")
	private int gcnt;
    
    @Column(name = "rmtyp")
    private String roomType;
    
    @Column(name = "rdmpntval")
    private int rdmpntval;
    
    @Column(name="status")
    private String status;
    
    @Column(name="rejrsn")
    private String rejrsn;
    
    @Column(name="rdmcod")
    private String rdmcod;

	public RedeemPoints() {
		
	}

	public RedeemPoints(Integer rdmid, Integer memno, String firstname, String surname, String ptrcod, String ptrnam, LocalDate chkindat,
			int daycnt, int gcnt, int rdmpntval, String status, String rejrsn, String roomType, String rdmcod) {
		super();
		this.rdmid = rdmid;
		this.memno = memno;
		this.firstname = firstname;
		this.surname = surname;
		this.ptrcod = ptrcod;
		this.ptrnam = ptrnam;
		this.chkindat = chkindat;
		this.daycnt = daycnt;
		this.gcnt = gcnt;
		this.roomType = roomType;
		this.rdmpntval = rdmpntval;
		this.status = status;
		this.rejrsn = rejrsn;
		this.rdmcod = rdmcod;
	}

	public Integer getRdmid() {
		return rdmid;
	}

	public Integer getMemno() {
		return memno;
	}

	public void setMemno(Integer memno) {
		this.memno = memno;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getSurname() {
		return surname;
	}

	public String getPtrcod() {
		return ptrcod;
	}

	public LocalDate getChkindat() {
		return chkindat;
	}

	public int getDaycnt() {
		return daycnt;
	}

	public int getGcnt() {
		return gcnt;
	}

	public int getRdmpntval() {
		return rdmpntval;
	}

	public String getStatus() {
		return status;
	}

	public String getRejrsn() {
		return rejrsn;
	}

	public void setRdmid(Integer rdmid) {
		this.rdmid = rdmid;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setPtrcod(String ptrcod) {
		this.ptrcod = ptrcod;
	}

	public void setChkindat(LocalDate chkindat) {
		this.chkindat = chkindat;
	}

	public void setDaycnt(int daycnt) {
		this.daycnt = daycnt;
	}

	public void setGcnt(int gcnt) {
		this.gcnt = gcnt;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public void setRdmpntval(int rdmpntval) {
		this.rdmpntval = rdmpntval;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRejrsn(String rejrsn) {
		this.rejrsn = rejrsn;
	}

	public String getRdmcod() {
		return rdmcod;
	}

	public void setRdmcod(String rdmcod) {
		this.rdmcod = rdmcod;
	}

	public String getPtrnam() {
		return ptrnam;
	}

	public void setPtrnam(String ptrnam) {
		this.ptrnam = ptrnam;
	}
	

}
