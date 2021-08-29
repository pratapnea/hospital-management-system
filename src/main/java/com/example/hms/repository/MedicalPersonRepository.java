package com.example.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hms.model.MedicalPerson;

public interface MedicalPersonRepository extends JpaRepository<MedicalPerson, Long> {

}
