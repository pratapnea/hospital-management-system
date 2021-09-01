package com.example.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hms.exception.PatientRecordNotFoundException;
import com.example.hms.model.PatientRecord;
import com.example.hms.repository.PatientRecordRepository;

@Service
public class PatientRecordService {
	
	@Autowired
	private PatientRecordRepository patientRecordRepository;
	
	// add patient record
	public PatientRecord addPatientRecord(PatientRecord patientRecord) {
		return patientRecordRepository.save(patientRecord);
	}
	
	// find all patient records
	public List<PatientRecord> findAllPatientRecords(){
		List<PatientRecord> patientRecords =  patientRecordRepository.findAll();
		if(patientRecords.isEmpty()) {
			throw new PatientRecordNotFoundException("We don't have any records to display at the moment!");
		}
		return patientRecords;
	}
	
	// find patient records by id
	public PatientRecord findPatientRecordById(Long id) {
		return patientRecordRepository.findById(id)
				.orElseThrow(() -> new PatientRecordNotFoundException("Patient Record Not Found!"));
		
	}
	
	// update patient record
	public PatientRecord updatePatientRecord(PatientRecord patientRecord) {
		return patientRecordRepository.save(patientRecord);
	}
	
	// delete patient record
	public void deletePatientRecord(Long id) {
		if(!patientRecordRepository.existsById(id)) {
			throw new PatientRecordNotFoundException("Patient Record Not Found!");
		}
		patientRecordRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	
	

}
