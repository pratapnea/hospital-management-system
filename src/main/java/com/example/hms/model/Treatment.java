package com.example.hms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Treatment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String treatmentType;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "treatment")
	private List<PatientRecord> patientRecords;
	
	public Treatment() {}
	
	public Treatment(String treatmentType) {
		super();
		this.treatmentType = treatmentType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTreatmentType() {
		return treatmentType;
	}

	public void setTreatmentType(String treatmentType) {
		this.treatmentType = treatmentType;
	}

	public List<PatientRecord> getPatientRecords() {
		return patientRecords;
	}

	public void setPatientRecords(List<PatientRecord> patientRecords) {
		this.patientRecords = patientRecords;
	}
	
	
	
	
	
}
