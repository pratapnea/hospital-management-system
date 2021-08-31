package com.example.hms.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hms.exception.MedicalPersonNotFoundException;
import com.example.hms.model.MedicalPerson;
import com.example.hms.repository.MedicalPersonRepository;
import com.example.hms.repository.PatientRepository;

@Service
public class MedicalPersonService {
	private MedicalPersonRepository medicalPersonRepository;
	private PatientRepository patientRepository;

	@Autowired
	public MedicalPersonService(MedicalPersonRepository medicalPersonRepository, PatientRepository patientRepository) {
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



}
