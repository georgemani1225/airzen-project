package com.geo.airzen.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="member")
public class Member {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="title")
    private String title;
    
    @Column(name="firstname")
    private String firstname;
   
    @Column(name="surname")
    private String surname;
    
    @Column(name="dob")
    private LocalDate dob;
    
    @Column(name="gender")
    private String gender;
    
    @Column(name="marsta")
    private String marsta;
    
    @Column(name="nationality")
    private String nationality;
    
    @Column(name="tier")
    private String tier;
    
    @Column(name="enrdat")
    private LocalDate enrdat;
    
    // define constructors
    public Member() {

    }

	public Member(Integer id, String title, String firstname, String surname, LocalDate dob, String gender, String marsta,
			String nationality, String tier, LocalDate enrdat) {
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
		this.enrdat = enrdat;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMarsta() {
		return marsta;
	}

	public void setMarsta(String marsta) {
		this.marsta = marsta;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public LocalDate getEnrdat() {
		return enrdat;
	}

	public void setEnrdat(LocalDate enrdat) {
		this.enrdat = enrdat;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", title=" + title + ", firstname=" + firstname + ", surname=" + surname + ", dob="
				+ dob + ", gender=" + gender + ", marsta=" + marsta + ", nationality=" + nationality + ", tier=" + tier
				+ "]";
	}
	
	
}





