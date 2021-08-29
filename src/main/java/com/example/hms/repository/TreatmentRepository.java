package com.example.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hms.model.Treatment;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {

}
