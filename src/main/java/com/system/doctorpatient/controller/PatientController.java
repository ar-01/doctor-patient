package com.system.doctorpatient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.doctorpatient.model.Patient;
import com.system.doctorpatient.model.exception.ResourceNotFoundException;
import com.system.doctorpatient.repository.PatientRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class PatientController {
	
	@Autowired
	private PatientRepository pr;
	
	@GetMapping("/patient")
	public List<Patient> findAllPatients()
	{
		return pr.findAll();
	}
	
	@PostMapping("/patient")
	public Patient createPatient(@RequestBody Patient patient)
	{
		return pr.save(patient);
	}
	
	@GetMapping("/patient/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long id)
	{
		Patient patient = pr.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Patient with id "+id+" doesn't exist"));
		return ResponseEntity.ok(patient);
	}
	
}
