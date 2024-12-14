package com.geo.airzen.entity;

import jakarta.persistence.*;

@Entity
@Table(name="memcntinf")
public class MemberContactInfo {

	// define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "adrtyp")
	private String adrtyp;

	@Column(name = "adrlinone")
	private String adrlinone;

	@Column(name = "adrlintwo")
	private String adrlintwo;

	@Column(name = "twn")
	private String twn;

	@Column(name = "dist")
	private String dist;

	@Column(name = "stt")
	private String stt;

	@Column(name = "ctry")
	private String ctry;

	@Column(name = "zipcod")
	private String zipcod;
	
	@Column(name="phntyp")
	private String phntyp;
	
	@Column(name="homisdcod")
	private String homisdcod;
	
	@Column(name="homarcod")
	private String homarcod;
	
	@Column(name="homphnnum")
	private String homphnnum;
	
	@Column(name="busisdcod")
	private String busisdcod;
	
	@Column(name="busarcod")
	private String busarcod;
	
	@Column(name="busphnnum")
	private String busphnnum;
	
	@Column(name="mobisdcod")
	private String mobisdcod;
	
	@Column(name="mobarcod")
	private String mobarcod;
	
	@Column(name="mobno")
	private String mobno;
	
	@Column(name="emadrtyp")
	private String emadrtyp;

	@Column(name="homemadr")
	private String homemadr;

	@Column(name="busemadr")
	private String busemadr;

	// define constructors
	public MemberContactInfo() {

	}

	public MemberContactInfo(Integer id, String adrtyp, String adrlinone, String adrlintwo, String twn, String dist,
			String stt, String ctry, String zipcod, String phntyp, String homisdcod, String homarcod, String homphnnum,
			String busisdcod, String busarcod, String busphnnum, String mobisdcod, String mobarcod, String mobno,
			String emadrtyp, String homemadr, String busemadr) {
		super();
		this.id = id;
		this.adrtyp = adrtyp;
		this.adrlinone = adrlinone;
		this.adrlintwo = adrlintwo;
		this.twn = twn;
		this.dist = dist;
		this.stt = stt;
		this.ctry = ctry;
		this.zipcod = zipcod;
		this.phntyp = phntyp;
		this.homisdcod = homisdcod;
		this.homarcod = homarcod;
		this.homphnnum = homphnnum;
		this.busisdcod = busisdcod;
		this.busarcod = busarcod;
		this.busphnnum = busphnnum;
		this.mobisdcod = mobisdcod;
		this.mobarcod = mobarcod;
		this.mobno = mobno;
		this.emadrtyp = emadrtyp;
		this.homemadr = homemadr;
		this.busemadr = busemadr;
	}

	public Integer getId() {
		return id;
	}

	public String getAdrtyp() {
		return adrtyp;
	}

	public String getAdrlinone() {
		return adrlinone;
	}

	public String getAdrlintwo() {
		return adrlintwo;
	}

	public String getTwn() {
		return twn;
	}

	public String getDist() {
		return dist;
	}

	public String getStt() {
		return stt;
	}

	public String getCtry() {
		return ctry;
	}

	public String getZipcod() {
		return zipcod;
	}

	public String getPhntyp() {
		return phntyp;
	}

	public String getHomisdcod() {
		return homisdcod;
	}

	public String getHomarcod() {
		return homarcod;
	}

	public String getHomphnnum() {
		return homphnnum;
	}

	public String getBusisdcod() {
		return busisdcod;
	}

	public String getBusarcod() {
		return busarcod;
	}

	public String getBusphnnum() {
		return busphnnum;
	}

	public String getMobisdcod() {
		return mobisdcod;
	}

	public String getMobarcod() {
		return mobarcod;
	}

	public String getMobno() {
		return mobno;
	}

	public String getEmadrtyp() {
		return emadrtyp;
	}

	public String getHomemadr() {
		return homemadr;
	}

	public String getBusemadr() {
		return busemadr;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAdrtyp(String adrtyp) {
		this.adrtyp = adrtyp;
	}

	public void setAdrlinone(String adrlinone) {
		this.adrlinone = adrlinone;
	}

	public void setAdrlintwo(String adrlintwo) {
		this.adrlintwo = adrlintwo;
	}

	public void setTwn(String twn) {
		this.twn = twn;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public void setStt(String stt) {
		this.stt = stt;
	}

	public void setCtry(String ctry) {
		this.ctry = ctry;
	}

	public void setZipcod(String zipcod) {
		this.zipcod = zipcod;
	}

	public void setPhntyp(String phntyp) {
		this.phntyp = phntyp;
	}

	public void setHomisdcod(String homisdcod) {
		this.homisdcod = homisdcod;
	}

	public void setHomarcod(String homarcod) {
		this.homarcod = homarcod;
	}

	public void setHomphnnum(String homphnnum) {
		this.homphnnum = homphnnum;
	}

	public void setBusisdcod(String busisdcod) {
		this.busisdcod = busisdcod;
	}

	public void setBusarcod(String busarcod) {
		this.busarcod = busarcod;
	}

	public void setBusphnnum(String busphnnum) {
		this.busphnnum = busphnnum;
	}

	public void setMobisdcod(String mobisdcod) {
		this.mobisdcod = mobisdcod;
	}

	public void setMobarcod(String mobarcod) {
		this.mobarcod = mobarcod;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public void setEmadrtyp(String emadrtyp) {
		this.emadrtyp = emadrtyp;
	}

	public void setHomemadr(String homemadr) {
		this.homemadr = homemadr;
	}

	public void setBusemadr(String busemadr) {
		this.busemadr = busemadr;
	}
	
}
