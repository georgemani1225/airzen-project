package com.geo.airzen.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.geo.airzen.entity.Preferences;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MemberDTO {

	private Integer id;

	private String title;

	@NotBlank(message = "First Name can not be empty")
	@Size(max = 80, message = "First Name must be at most 80 characters long")
	private String firstname;

	@NotBlank(message = "Surname cannot be empty")
	@Size(max = 80, message = "Surname must be at most 80 characters long")
	private String surname;

	@NotBlank(message = "Date cannot be empty")
	private String dob;

	@NotBlank(message = "Gender cannot be empty")
	private String gender;

	private String marsta;

	@NotBlank(message = "Nationality cannot be empty")
	private String nationality;

	private String tier;

	@NotBlank(message = "Preferred Address cannot be empty")
	private String adrtyp;

	@NotBlank(message = "Address Line One cannot be empty")
	@Size(max = 100, message = "Address Line One must be at most 100 characters long")
	private String adrlinone;

	@NotBlank(message = "Address Line Two cannot be empty")
	@Size(max = 100, message = "Address Line Two must be at most 100 characters long")
	private String adrlintwo;

	@NotBlank(message = "Town cannot be empty")
	@Size(max = 100, message = "Town must be at most 100 characters long")
	private String twn;

	@NotBlank(message = "District cannot be empty")
	@Size(max = 100, message = "District must be at most 100 characters long")
	private String dist;

	@NotBlank(message = "State cannot be empty")
	@Size(max = 100, message = "State must be at most 100 characters long")
	private String stt;

	@NotBlank(message = "Country cannot be empty")
	private String ctry;

	@NotBlank(message = "Zip Code cannot be empty")
	@Size(max = 10, message = "Zip Code must be at most 10 characters long")
	private String zipcod;

	private String phntyp;

	private String homisdcod;

	private String homarcod;

	private String homphnnum;

	private String busisdcod;

	private String busarcod;

	private String busphnnum;

	private String mobisdcod;

	private String mobarcod;

	private String mobno;

	private String emadrtyp;

	private String homemadr;

	private String busemadr;

	private Integer memid;

	private Integer docid;

	private List<String> docType;

	private List<MultipartFile> data;
	
	private Preferences preferences;
	
	private int aznpnt;

	private int ttlpnt;

	private int lngcpn;

	private int fltcnt;
	
	private String nextTier;

	private int tgtPnt;

	private int tierttlpnt;

	private int tierfltcnt;

	private int tgtFltCnt;
	
	private String enrdat;

	// define constructors
	public MemberDTO() {

	}

	public MemberDTO(Integer id, String title, String firstname, String surname, String dob, String gender,
			String marsta, String nationality, String tier, String adrtyp, String adrlinone, String adrlintwo,
			String twn, String dist, String stt, String ctry, String zipcod, String phntyp, String homisdcod,
			String homarcod, String homphnnum, String busisdcod, String busarcod, String busphnnum, String mobisdcod,
			String mobarcod, String mobno, String emadrtyp, String homemadr, String busemadr, Integer memid, Integer docid, List<String> docType,
			List<MultipartFile> data, Preferences preferences, int aznpnt, int ttlpnt, int lngcpn, int fltcnt, String nextTier, int tgtPnt, int tierttlpnt, int tierfltcnt, int tgtFltCnt, String enrdat) {
		super();
		this.id = id;
		this.title = title;
		this.firstname = firstname;
		this.surname = surname;
		this.dob = dob;
		this.gender = gender;
		this.marsta = marsta;
		this.nationality = nationality;
		this.tier = tier;
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
		this.mobno = mobno;
		this.emadrtyp = emadrtyp;
		this.homemadr = homemadr;
		this.busemadr = busemadr;
		this.docid = docid;
		this.memid = memid;
		this.docType = docType;
		this.data = data;
		this.preferences = preferences;
		this.aznpnt = aznpnt;
		this.ttlpnt = ttlpnt;
		this.lngcpn = lngcpn;
		this.fltcnt = fltcnt;
		this.nextTier = nextTier;
		this.tgtPnt = tgtPnt;
		this.tierttlpnt = tierttlpnt;
		this.tierfltcnt = tierfltcnt;
		this.tgtFltCnt = tgtFltCnt;
		this.enrdat = enrdat;
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getSurname() {
		return surname;
	}

	public String getDob() {
		return dob;
	}

	public String getGender() {
		return gender;
	}

	public String getMarsta() {
		return marsta;
	}

	public String getNationality() {
		return nationality;
	}

	public String getTier() {
		return tier;
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

	public Integer getMemid() {
		return memid;
	}

	public Integer getDocid() {
		return docid;
	}

	public List<String> getDocType() {
		return docType;
	}

	public List<MultipartFile> getData() {
		return data;
	}

	public Preferences getPreferences() {
		return preferences;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setMarsta(String marsta) {
		this.marsta = marsta;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public void setTier(String tier) {
		this.tier = tier;
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

	public void setMemid(Integer memid) {
		this.memid = memid;
	}

	public void setDocid(Integer docid) {
		this.docid = docid;
	}

	public void setDocType(List<String> docType) {
		this.docType = docType;
	}

	public void setData(List<MultipartFile> data) {
		this.data = data;
	}

	public void setPreferences(Preferences preferences) {
		this.preferences = preferences;
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

	public String getEnrdat() {
		return enrdat;
	}

	public void setEnrdat(String enrdat) {
		this.enrdat = enrdat;
	}
	
}
