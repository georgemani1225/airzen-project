package com.geo.airzen.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EarnPointsDTO {

	private Integer actnum;

	private Integer memno;

	@NotBlank(message = "Firstname can not be empty")
	private String firstname;

	@NotBlank(message = "Surname can not be empty")
	private String surname;

	@NotNull(message = "Flight Date can not be empty")
	private LocalDate fltdat;

	@NotBlank(message = "Flight No can not be empty")
	private String fltno;

	@NotBlank(message = "Cabin Class can not be empty")
	private String cbncls;

	@NotBlank(message = "Orgin can not be empty")
	private String org;

	@NotBlank(message = "Destination can not be empty")
	private String dest;

	@NotBlank(message = "Booking Class can not be empty")
	private String bkgcls;

	@NotBlank(message = "Seat No can not be empty")
	private String seatno;

	@NotBlank(message = "Ticket No can not be empty")
	private String tktno;

	@NotBlank(message = "PNR can not be empty")
	private String pnr;

	private int pntval;

	private int aznpnt;

	private int ttlpnt;

	private int lngcpn;

	private int fltcnt;

	private String formattedDate;

	private String status;

	private String rejrsn;

	private String tier;

	private String nextTier;

	private int tgtPnt;

	private int tierttlpnt;

	private int tierfltcnt;

	private int tgtFltCnt;

	public EarnPointsDTO() {

	}

	public EarnPointsDTO(Integer actnum, Integer memno, String firstname, String surname, LocalDate fltdat, String fltno,
			String cbncls, String org, String dest, String bkgcls, String seatno, String tktno, String pnr, int pntval,
			int aznpnt, int ttlpnt, int lngcpn, int fltcnt, String formattedDate, String status, String rejrsn,
			String tier, String nextTier, int tgtPnt, int tierttlpnt, int tierfltcnt, int tgtFltCnt) {
		super();
		this.actnum = actnum;
		this.memno = memno;
		this.firstname = firstname;
		this.surname = surname;
		this.fltdat = fltdat;
		this.fltno = fltno;
		this.cbncls = cbncls;
		this.org = org;
		this.dest = dest;
		this.bkgcls = bkgcls;
		this.seatno = seatno;
		this.tktno = tktno;
		this.pnr = pnr;
		this.pntval = pntval;
		this.aznpnt = aznpnt;
		this.ttlpnt = ttlpnt;
		this.lngcpn = lngcpn;
		this.fltcnt = fltcnt;
		this.formattedDate = formattedDate;
		this.status = status;
		this.rejrsn = rejrsn;
		this.tier = tier;
		this.nextTier = nextTier;
		this.tgtPnt = tgtPnt;
		this.tierttlpnt = tierttlpnt;
		this.tierfltcnt = tierfltcnt;
		this.tgtFltCnt = tgtFltCnt;
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

	public int getAznpnt() {
		return aznpnt;
	}

	public void setAznpnt(int aznpnt) {
		this.aznpnt = aznpnt;
	}

	public int getTtlpnt() {
		return ttlpnt;
	}

	public void setTtlpnt(int ttlpnt) {
		this.ttlpnt = ttlpnt;
	}

	public int getLngcpn() {
		return lngcpn;
	}

	public void setLngcpn(int lngcpn) {
		this.lngcpn = lngcpn;
	}

	public int getFltcnt() {
		return fltcnt;
	}

	public void setFltcnt(int fltcnt) {
		this.fltcnt = fltcnt;
	}

	public String getFormattedDate() {
		return formattedDate;
	}

	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
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

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public String getNextTier() {
		return nextTier;
	}

	public void setNextTier(String nextTier) {
		this.nextTier = nextTier;
	}

	public int getTgtPnt() {
		return tgtPnt;
	}

	public void setTgtPnt(int tgtPnt) {
		this.tgtPnt = tgtPnt;
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

	public int getTgtFltCnt() {
		return tgtFltCnt;
	}

	public void setTgtFltCnt(int tgtFltCnt) {
		this.tgtFltCnt = tgtFltCnt;
	}
	
	

}
