package com.example.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hms.exception.TreatmentNotFoundException;
import com.example.hms.model.Treatment;
import com.example.hms.repository.TreatmentRepository;

@Service
public class TreatmentService {
	private TreatmentRepository treatmentRepository;
	
	@Autowired
	public TreatmentService(TreatmentRepository treatmentRepository) {
		this.treatmentRepository = treatmentRepository;
	}
	
	// add treatment
	public Treatment addTreatment(Treatment treatment) {
		return treatmentRepository.save(treatment);
	}
	
	// find all treatment
	public List<Treatment> findAllTreatment() {
		return treatmentRepository.findAll();
	}
	
	// find treatment by id
	public Treatment findTreatmentById(Long id) {
		return treatmentRepository.findById(id)
				.orElseThrow(() -> new TreatmentNotFoundException("Treatment Not Found!"));
	}
	
	// update treatment
	public Treatment updateTreatment(Treatment treatment) {
		return treatmentRepository.save(treatment);
	}
	
	
	// delete treatment
	public void deleteTreatment(Long id) {
		treatmentRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
