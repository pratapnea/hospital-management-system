package com.example.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hms.exception.PatientNotFoundException;
import com.example.hms.model.Patient;
import com.example.hms.repository.PatientRepository;
import com.example.hms.repository.TreatmentRepository;

@Service
public class PatientService {
	private PatientRepository patientRepository;
	private TreatmentRepository treatmentRepository;
	
	@Autowired
	public PatientService(PatientRepository patientRepository, 
						  TreatmentRepository treatmentRepository) {
		this.patientRepository = patientRepository;
		this.treatmentRepository = treatmentRepository;
	}
	
	
	// add patient
	public Patient addPatient(Patient patient) {
		return patientRepository.save(patient);
	}
	
	// find all patient
	public List<Patient> findAllPatient() {
		return patientRepository.findAll();
	}
	
	// find patient by id
	public Patient findPatientById(Long id) {
		return patientRepository.findById(id)
				.orElseThrow(()-> new PatientNotFoundException("Patient Not Found!"));
	}
	
	// update patient
	public Patient updatePatient(Patient patient) {
		return patientRepository.save(patient);
	}
	
	// delete patient
	public void deletePatient(Long id) {
		patientRepository.deleteById(id);
	}
	
	
	
	

}
