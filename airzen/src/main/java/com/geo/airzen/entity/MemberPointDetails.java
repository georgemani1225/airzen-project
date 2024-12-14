package com.geo.airzen.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mempntdtl")
public class MemberPointDetails {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "aznpnt")
	private int aznpnt;

	@Column(name = "ttlpnt")
	private int ttlpnt;

	@Column(name = "lngcpn")
	private int lngcpn;

	@Column(name = "fltcnt")
	private int fltcnt;

	public MemberPointDetails() {

	}

	public MemberPointDetails(Integer id, int aznpnt, int ttlpnt, int lngcpn, int fltcnt) {
		super();
		this.id = id;
		this.aznpnt = aznpnt;
		this.ttlpnt = ttlpnt;
		this.lngcpn = lngcpn;
		this.fltcnt = fltcnt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	

}
