package com.example.hms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PatientRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private MedicalPerson medicalPerson;
	@ManyToOne
	private Treatment treatment;
	@ManyToOne
	private Patient patient;
	
	public PatientRecord() {}

	public PatientRecord(MedicalPerson medicalPerson, Treatment treatment, Patient patient) {
		super();
		this.medicalPerson = medicalPerson;
		this.treatment = treatment;
		this.patient = patient;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MedicalPerson getMedicalPerson() {
		return medicalPerson;
	}

	public void setMedicalPerson(MedicalPerson medicalPerson) {
		this.medicalPerson = medicalPerson;
	}

	public Treatment getTreatment() {
		return treatment;
	}

	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
}
