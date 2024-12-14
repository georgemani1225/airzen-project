package com.geo.airzen.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "memdocinf")
public class MemberDocumentInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="docid")
	private Integer docid;
	
	@Column(name="memid")
    private Integer memid;
	
	@Column(name="doctyp")
    private String docType;
	
	@Lob
    @Column(name = "data")
	private byte[] data;

	public MemberDocumentInfo() {
		
	}

	public MemberDocumentInfo(Integer docid, Integer memid, String docType, byte[] data) {
		super();
		this.docid = docid;
		this.memid = memid;
		this.docType = docType;
		this.data = data;
	}
	
	public Integer getDocid() {
		return docid;
	}
	
	public Integer getMemid() {
		return memid;
	}

	public String getDocType() {
		return docType;
	}

	public byte[] getData() {
		return data;
	}
	
	public void setDocid(Integer docid) {
		this.docid = docid;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public void setMemid(Integer memid) {
		this.memid = memid;
	}
	
}
