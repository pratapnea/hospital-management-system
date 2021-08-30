package com.example.hms.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hms.exception.MedicalPersonNotFoundException;
import com.example.hms.exception.PatientNotFoundException;
import com.example.hms.model.MedicalPerson;
import com.example.hms.model.Patient;
import com.example.hms.repository.MedicalPersonRepository;
import com.example.hms.repository.PatientRepository;

@Service
public class MedicalPersonService {
	private MedicalPersonRepository medicalPersonRepository;
	private PatientRepository patientRepository;
	
	@Autowired
	public MedicalPersonService(MedicalPersonRepository medicalPersonRepository,
			PatientRepository patientRepository) {
		this.medicalPersonRepository = medicalPersonRepository;
		this.patientRepository = patientRepository;
	}
	
	// add medical person
	public MedicalPerson addMedicalPerson(MedicalPerson medicalPerson) {
		medicalPerson.setCodeNumber(UUID.randomUUID().toString());
		return medicalPersonRepository.save(medicalPerson);
	}
	
	// find all medical person
	public List<MedicalPerson> findAllMedicalPerson() {
		return medicalPersonRepository.findAll();
	}
	
	// find medical person by id
	public MedicalPerson findMedicalPersonById(Long id) {
		return medicalPersonRepository.findById(id)
				.orElseThrow(() -> new MedicalPersonNotFoundException("Medical Person Not Found!"));
	}
	
	// update medical person
	public MedicalPerson updateMedicalPerson(MedicalPerson medicalPerson) {
		return medicalPersonRepository.save(medicalPerson);
	}
	
	// delete medical person
	public void deleteMedicalPerson(Long id) {
		medicalPersonRepository.deleteById(id);
	}
	
	// add patient to medical person
	public void addPatientToMedicalPerson(Long patientId, Long medicalPersonId) {
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new PatientNotFoundException("Patient Not Found!"));
				
		MedicalPerson medicalPerson = findMedicalPersonById(medicalPersonId);
		
		medicalPerson.getPatients().add(patient);
		medicalPersonRepository.save(medicalPerson);
	}
	
	// list patients of medical person
	public List<Patient> findPatientsOfMedicalPersonByMPId(Long mpId) {
		if(!medicalPersonRepository.existsById(mpId)) {
			throw new MedicalPersonNotFoundException("Medical Person Not Found!");
		}
		
		return patientRepository.findByMedicalPersonId(mpId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
