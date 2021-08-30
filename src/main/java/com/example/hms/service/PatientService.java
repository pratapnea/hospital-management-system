package com.example.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hms.exception.PatientNotFoundException;
import com.example.hms.exception.TreatmentNotFoundException;
import com.example.hms.model.Patient;
import com.example.hms.model.Treatment;
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
	
	// add treatment to a patient
	public void addTreatmentToPatient(Long treatmentId, Long patientId) {
		Treatment treatment = treatmentRepository.findById(treatmentId)
				.orElseThrow(() -> new TreatmentNotFoundException("Treatment Not Found!"));
			
		Patient patient = findPatientById(patientId);
		
		patient.getTreatment().add(treatment);
		addPatient(patient);
		
	}
	 
	
	// add treatments to a patients
	public void addTreatmentstoPatient(List<Treatment> treatments, Long patientId) {
		if(!patientRepository.existsById(patientId)) {
			throw new PatientNotFoundException("Patient Not Found!");
		}
		Patient patient = findPatientById(patientId);
		patient.getTreatment().addAll(treatments);
		addPatient(patient);
	}
	
	
	// find treatments of patient
	public List<Treatment> findTreatmentsofPatientByPatientId(Long patientId) {
		if(!patientRepository.existsById(patientId)) {
			throw new PatientNotFoundException("Patient Not Found!");
		}
		return treatmentRepository.findByPatientId(patientId);
	}

	
	
	
	
	
	
	
	

	
	
	
	

}
