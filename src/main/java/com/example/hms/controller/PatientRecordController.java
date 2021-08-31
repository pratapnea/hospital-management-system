package com.example.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hms.exception.PatientRecordNotFoundException;
import com.example.hms.model.PatientRecord;
import com.example.hms.repository.PatientRecordRepository;
import com.example.hms.service.MedicalPersonService;
import com.example.hms.service.PatientService;
import com.example.hms.service.TreatmentService;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("/api/v1/patient-record/")
public class PatientRecordController {
	@Autowired
	private TreatmentService treatmentService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private MedicalPersonService medicalPersonService;
	@Autowired
	private PatientRecordRepository patientRecordRepository;
	
	@PostMapping("/add")
	public ResponseEntity<PatientRecord> addPatientRecord(PatientRecord patientRecord){
		PatientRecord patientRecord2 = patientRecordRepository.save(patientRecord);
		return new ResponseEntity<>(patientRecord2, HttpStatus.CREATED);
	}
	
	@GetMapping("/find")
	public ResponseEntity<List<PatientRecord>> findPatientRecord(){
		List<PatientRecord> patientRecords = patientRecordRepository.findAll();
		return new ResponseEntity<>(patientRecords, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<PatientRecord> findPatientRecordById(@PathVariable("id") Long id){
		PatientRecord patientRecords = patientRecordRepository.findById(id)
				.orElseThrow(() -> new PatientRecordNotFoundException("Patient Not Found!"));
		return new ResponseEntity<>(patientRecords, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
