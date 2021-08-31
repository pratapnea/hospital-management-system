package com.example.hms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hms.model.Treatment;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
}
