package com.example.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hms.model.PatientRecord;
import com.example.hms.service.PatientRecordService;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("/api/v1/patient-record/")
public class PatientRecordController {
	@Autowired
	private PatientRecordService patientRecordService;
	
	@PostMapping("/add")
	public ResponseEntity<PatientRecord> addPatientRecord(@RequestBody PatientRecord patientRecord){
		PatientRecord patientRecord2 = patientRecordService.addPatientRecord(patientRecord);
		return new ResponseEntity<>(patientRecord2, HttpStatus.CREATED);
	}
	
	@GetMapping("/find")
	public ResponseEntity<List<PatientRecord>> findPatientRecord(){
		List<PatientRecord> patientRecords = patientRecordService.findAllPatientRecords();
		return new ResponseEntity<>(patientRecords, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<PatientRecord> findPatientRecordById(@PathVariable("id") Long id){
		PatientRecord patientRecords = patientRecordService.findPatientRecordById(id);
			
		return new ResponseEntity<>(patientRecords, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<PatientRecord> updatePatientRecord(@RequestBody PatientRecord patientRecord){
		PatientRecord updatePatientRecord = patientRecordService.updatePatientRecord(patientRecord);
		
		return new ResponseEntity<PatientRecord>(updatePatientRecord, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PatientRecord> deletePatientRecord(@PathVariable("id") Long id) {
		patientRecordService.deletePatientRecord(id);
		
		return new ResponseEntity<PatientRecord>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
