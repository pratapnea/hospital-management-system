package com.example.hms.controller;

import java.util.List;

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

import com.example.hms.model.Patient;
import com.example.hms.service.PatientService;

@RestController
@RequestMapping("/api/v1/patient/")
public class PatientController {
	private PatientService patientService;
	
	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Patient>> getAllPatients() {
		List<Patient> patients = patientService.findAllPatient();
		
		return new ResponseEntity<>(patients, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable("id") Long id) {
		Patient patient = patientService.findPatientById(id);
		
		return new ResponseEntity<Patient>(patient,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
		Patient newPatient = patientService.addPatient(patient);
		
		return new ResponseEntity<Patient>(newPatient, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
		Patient updatePatient = patientService.updatePatient(patient);
		
		return new ResponseEntity<Patient>(updatePatient, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Patient> deletePatient(@PathVariable("id") Long id) {
		patientService.deletePatient(id);
		
		return new ResponseEntity<Patient>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
