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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.hms.model.Treatment;
import com.example.hms.service.TreatmentService;

import io.swagger.annotations.Api;
@Api
@RestController
@RequestMapping("/api/v1/treatment/")
public class TreatmentController {
	private final TreatmentService treatmentService;
	
	public TreatmentController(TreatmentService treatmentService) {
		this.treatmentService = treatmentService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Treatment>> getAllTreatments() {
		List<Treatment> treatments = treatmentService.findAllTreatment();
		
		return new ResponseEntity<>(treatments, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Treatment> getTreatmentById(@PathVariable("id") Long id) {
		Treatment treatment = treatmentService.findTreatmentById(id);
		
		return new ResponseEntity<Treatment>(treatment, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Treatment> addTreatment(@RequestBody Treatment treatment) {
		Treatment newTreatment = treatmentService.addTreatment(treatment);
		return new ResponseEntity<Treatment>(newTreatment, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Treatment> updateTreatment(@RequestBody Treatment treatment) {
		Treatment updateTreatment = treatmentService.updateTreatment(treatment);
		return new ResponseEntity<Treatment>(updateTreatment, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Treatment> deleteTreatment(@PathVariable("id") Long id) {
		treatmentService.deleteTreatment(id);
		return new ResponseEntity<Treatment>(HttpStatus.OK);
	}

}
