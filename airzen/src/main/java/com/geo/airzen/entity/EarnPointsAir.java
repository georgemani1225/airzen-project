package com.geo.airzen.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="epactair")
public class EarnPointsAir {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="actnum")
    private Integer actnum;
	
	@Column(name="memno")
    private Integer memno;

    @Column(name="fltdat")
    private LocalDate fltdat;
    
    @Column(name="fltno")
    private String fltno;
   
    @Column(name="cbncls")
    private String cbncls;
    
    @Column(name="org")
    private String org;
    
    @Column(name="dest")
    private String dest;
    
    @Column(name="bkgcls")
    private String bkgcls;
    
    @Column(name="seatno")
    private String seatno;
    
    @Column(name="tktno")
    private String tktno;
    
    @Column(name="pnr")
    private String pnr;
    
    @Column(name="firstname")
    private String firstname;
    
    @Column(name="surname")
    private String surname;
    
    @Column(name = "pntval")
    private int pntval;
    
    @Column(name="status")
    private String status;
    
    @Column(name="rejrsn")
    private String rejrsn;
    
    
    // define constructors
    public EarnPointsAir() {

    }
    
	public EarnPointsAir(Integer actnum, Integer memno, LocalDate fltdat, String fltno, String cbncls, String org,
			String dest, String bkgcls, String seatno, String tktno, String pnr, String firstname, String surname,
			int pntval, String status, String rejrsn) {
		super();
		this.actnum = actnum;
		this.memno = memno;
		this.fltdat = fltdat;
		this.fltno = fltno;
		this.cbncls = cbncls;
		this.org = org;
		this.dest = dest;
		this.bkgcls = bkgcls;
		this.seatno = seatno;
		this.tktno = tktno;
		this.pnr = pnr;
		this.firstname = firstname;
		this.surname = surname;
		this.pntval = pntval;
		this.status = status;
		this.rejrsn = rejrsn;
	}


	public Integer getActnum() {
		return actnum;
	}

	public void setActnum(Integer actnum) {
		this.actnum = actnum;
	}

	public Integer getMemno() {
		return memno;
	}

	public void setMemno(Integer memno) {
		this.memno = memno;
	}

	public LocalDate getFltdat() {
		return fltdat;
	}

	public void setFltdat(LocalDate fltdat) {
		this.fltdat = fltdat;
	}

	public String getFltno() {
		return fltno;
	}

	public void setFltno(String fltno) {
		this.fltno = fltno;
	}

	public String getCbncls() {
		return cbncls;
	}

	public void setCbncls(String cbncls) {
		this.cbncls = cbncls;
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

	public String getBkgcls() {
		return bkgcls;
	}

	public void setBkgcls(String bkgcls) {
		this.bkgcls = bkgcls;
	}

	public String getSeatno() {
		return seatno;
	}

	public void setSeatno(String seatno) {
		this.seatno = seatno;
	}

	public String getTktno() {
		return tktno;
	}

	public void setTktno(String tktno) {
		this.tktno = tktno;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	
	public int getPntval() {
		return pntval;
	}

	public void setPntval(int pntval) {
		this.pntval = pntval;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRejrsn() {
		return rejrsn;
	}

	public void setRejrsn(String rejrsn) {
		this.rejrsn = rejrsn;
	}
	
	
	
	

}
