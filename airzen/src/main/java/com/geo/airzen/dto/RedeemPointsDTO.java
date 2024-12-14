package com.geo.airzen.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RedeemPointsDTO {

	private Integer rdmid;

	@NotNull
	private Integer memno;

	@NotBlank(message = "Firstname can not be empty")
	private String firstname;

	@NotBlank(message = "Surname can not be empty")
	private String surname;

	@NotBlank(message = "Enter Partner Code")
	private String ptrcod;

	@NotNull(message = "Enter Check-In Date")
	private LocalDate chkindat;

	@NotNull(message = "Enter number of days")
	private Integer daycnt;

	@NotNull(message = "Enter Number of Guests")
	private Integer gcnt;

	private String roomType;

	private int pnts;

	private int ttlrdmpnts;

	private String status;

	private String rejrsn;

	private String ptrnam;

	private String formattedDate;

	private String tier;

	private String nextTier;

	private int tgtPnt;

	private int tierttlpnt;

	private int tierfltcnt;

	private int tgtFltCnt;

	private String rdmcod;

	private int aznpnt;

	private int ttlpnt;

	private int lngcpn;

	private int fltcnt;

	public RedeemPointsDTO() {

	}

	public RedeemPointsDTO(Integer rdmid, Integer memno, String firstname, String surname, String ptrcod,
			LocalDate chkindat, Integer daycnt, Integer gcnt, int pnts, int ttlrdmpnts, String status, String rejrsn,
			String ptrnam, String roomType, String formattedDate, String tier, String nextTier, int tgtPnt,
			int tierttlpnt, int tierfltcnt, int tgtFltCnt, String rdmcod, int aznpnt, int ttlpnt, int lngcpn,
			int fltcnt) {
		super();
		this.rdmid = rdmid;
		this.memno = memno;
		this.firstname = firstname;
		this.surname = surname;
		this.ptrcod = ptrcod;
		this.chkindat = chkindat;
		this.daycnt = daycnt;
		this.gcnt = gcnt;
		this.roomType = roomType;
		this.pnts = pnts;
		this.ttlrdmpnts = ttlrdmpnts;
		this.status = status;
		this.rejrsn = rejrsn;
		this.ptrnam = ptrnam;
		this.formattedDate = formattedDate;
		this.tier = tier;
		this.nextTier = nextTier;
		this.tgtPnt = tgtPnt;
		this.tierttlpnt = tierttlpnt;
		this.tierfltcnt = tierfltcnt;
		this.tgtFltCnt = tgtFltCnt;
		this.rdmcod = rdmcod;
		this.aznpnt = aznpnt;
		this.ttlpnt = ttlpnt;
		this.lngcpn = lngcpn;
		this.fltcnt = fltcnt;
	}

	public Integer getRdmid() {
		return rdmid;
	}

	public void setRdmid(Integer rdmid) {
		this.rdmid = rdmid;
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

	public Integer getDaycnt() {
		return daycnt;
	}

	public Integer getGcnt() {
		return gcnt;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
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

	public void setDaycnt(Integer daycnt) {
		this.daycnt = daycnt;
	}

	public void setGcnt(Integer gcnt) {
		this.gcnt = gcnt;
	}

	public int getPnts() {
		return pnts;
	}

	public int getttlrdmpnts() {
		return ttlrdmpnts;
	}

	public void setPnts(int pnts) {
		this.pnts = pnts;
	}

	public void setttlrdmpnts(int ttlrdmpnts) {
		this.ttlrdmpnts = ttlrdmpnts;
	}

	public Integer getMemno() {
		return memno;
	}

	public void setMemno(Integer memno) {
		this.memno = memno;
	}

	public int getTtlrdmpnts() {
		return ttlrdmpnts;
	}

	public String getPtrnam() {
		return ptrnam;
	}

	public void setTtlrdmpnts(int ttlrdmpnts) {
		this.ttlrdmpnts = ttlrdmpnts;
	}

	public void setPtrnam(String ptrnam) {
		this.ptrnam = ptrnam;
	}

	public String getStatus() {
		return status;
	}

	public String getRejrsn() {
		return rejrsn;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRejrsn(String rejrsn) {
		this.rejrsn = rejrsn;
	}

	public String getFormattedDate() {
		return formattedDate;
	}

	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
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

	public int getTgtPnt() {
		return tgtPnt;
	}

	public int getTierttlpnt() {
		return tierttlpnt;
	}

	public int getTierfltcnt() {
		return tierfltcnt;
	}

	public int getTgtFltCnt() {
		return tgtFltCnt;
	}

	public void setNextTier(String nextTier) {
		this.nextTier = nextTier;
	}

	public void setTgtPnt(int tgtPnt) {
		this.tgtPnt = tgtPnt;
	}

	public void setTierttlpnt(int tierttlpnt) {
		this.tierttlpnt = tierttlpnt;
	}

	public void setTierfltcnt(int tierfltcnt) {
		this.tierfltcnt = tierfltcnt;
	}

	public void setTgtFltCnt(int tgtFltCnt) {
		this.tgtFltCnt = tgtFltCnt;
	}

	public String getRdmcod() {
		return rdmcod;
	}

	public void setRdmcod(String rdmcod) {
		this.rdmcod = rdmcod;
	}

	public int getAznpnt() {
		return aznpnt;
	}

	public int getTtlpnt() {
		return ttlpnt;
	}

	public int getLngcpn() {
		return lngcpn;
	}

	public int getFltcnt() {
		return fltcnt;
	}

	public void setAznpnt(int aznpnt) {
		this.aznpnt = aznpnt;
	}

	public void setTtlpnt(int ttlpnt) {
		this.ttlpnt = ttlpnt;
	}

	public void setLngcpn(int lngcpn) {
		this.lngcpn = lngcpn;
	}

	public void setFltcnt(int fltcnt) {
		this.fltcnt = fltcnt;
	}
	

}
