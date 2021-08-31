package com.example.hms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class MedicalPerson implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String firstName;
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	private MedicalTitle title;
	
	private String address;
	private String qualification;
	private String specialization;
	private String phone;
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(nullable = false, updatable = false)
	private String codeNumber;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "medicalPerson")
	private List<PatientRecord> patientsRecords;
	
	public MedicalPerson() {}
	
	public MedicalPerson(String firstName, String lastName, MedicalTitle title, String address, String qualification,
			String specialization, String phone, String email, Gender gender, String codeNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.address = address;
		this.qualification = qualification;
		this.specialization = specialization;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.codeNumber = codeNumber;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public MedicalTitle getTitle() {
		return title;
	}

	public void setTitle(MedicalTitle title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getCodeNumber() {
		return codeNumber;
	}

	public void setCodeNumber(String codeNumber) {
		this.codeNumber = codeNumber;
	}

	public List<PatientRecord> getPatientsRecords() {
		return patientsRecords;
	}

	public void setPatientsRecords(List<PatientRecord> patientsRecords) {
		this.patientsRecords = patientsRecords;
	}

	
	
}
