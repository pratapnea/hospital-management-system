package com.example.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hms.exception.PatientNotFoundException;
import com.example.hms.model.Patient;
import com.example.hms.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
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
		if(!patientRepository.existsById(id)) {
			throw new PatientNotFoundException("Patient Not Found!");
		}
		patientRepository.deleteById(id);
	}
	
	
	
	

}
