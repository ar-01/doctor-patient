package com.system.doctorpatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.doctorpatient.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
}
