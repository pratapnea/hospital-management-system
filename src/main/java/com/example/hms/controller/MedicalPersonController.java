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

import com.example.hms.model.MedicalPerson;
import com.example.hms.service.MedicalPersonService;

@RestController
@RequestMapping("/api/v1/medical-person/")
public class MedicalPersonController {
	private MedicalPersonService medicalPersonService;
	
	public MedicalPersonController(MedicalPersonService medicalPersonService) {
		this.medicalPersonService = medicalPersonService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<MedicalPerson>> getAllMedicalPerson() {
		List<MedicalPerson> medicalPersons = medicalPersonService.findAllMedicalPerson();
		
		return new ResponseEntity<>(medicalPersons, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<MedicalPerson> getMedicalPersonById(@PathVariable("id") Long id) {
		MedicalPerson medicalPerson = medicalPersonService.findMedicalPersonById(id);
		
		return new ResponseEntity<MedicalPerson>(medicalPerson, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<MedicalPerson> addMedicalPerson(@RequestBody MedicalPerson medicalPerson) {
		MedicalPerson newMedicalPerson = medicalPersonService.addMedicalPerson(medicalPerson);
		
		return new ResponseEntity<MedicalPerson>(newMedicalPerson, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<MedicalPerson> updateMedicalPerson(@RequestBody MedicalPerson medicalPerson) {
		MedicalPerson updateMedicalPerson = medicalPersonService.updateMedicalPerson(medicalPerson);
		
		return new ResponseEntity<MedicalPerson>(updateMedicalPerson, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<MedicalPerson> deleteMedicalPerson(@PathVariable("id") Long id) {
		medicalPersonService.deleteMedicalPerson(id);
		
		return new ResponseEntity<MedicalPerson>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
