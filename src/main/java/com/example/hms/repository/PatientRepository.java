package com.example.hms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hms.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
