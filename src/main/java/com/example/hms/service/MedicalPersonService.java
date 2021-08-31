package com.example.hms.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hms.exception.MedicalPersonNotFoundException;
import com.example.hms.model.MedicalPerson;
import com.example.hms.repository.MedicalPersonRepository;

@Service
public class MedicalPersonService {
	
	@Autowired
	private MedicalPersonRepository medicalPersonRepository;


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
		if(!medicalPersonRepository.existsById(id)) {
			throw new MedicalPersonNotFoundException("Medical Person Not Found!");
		}
		medicalPersonRepository.deleteById(id);
	}



}
