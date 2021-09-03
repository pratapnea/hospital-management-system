package com.example.hms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.hms.utils.Gender;

@Entity
public class Patient implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String firstName;
	private String lastNaame;
	private String address;
	private int age;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String phone;
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
//	private List<PatientRecord> patientRecords = new ArrayList<>();
	
	
	public Patient() {}


	public Patient(String firstName, String lastNaame, String address, int age, Gender gender, String phone) {
		super();
		this.firstName = firstName;
		this.lastNaame = lastNaame;
		this.address = address;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastNaame() {
		return lastNaame;
	}


	public void setLastNaame(String lastNaame) {
		this.lastNaame = lastNaame;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

//
//	public List<PatientRecord> getPatientRecords() {
//		return patientRecords;
//	}
//
//
//	public void setPatientRecords(List<PatientRecord> patientRecords) {
//		this.patientRecords = patientRecords;
//	}



	
	

}
