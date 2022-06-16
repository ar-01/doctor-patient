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

import com.system.doctorpatient.model.Doctor;
import com.system.doctorpatient.model.exception.ResourceNotFoundException;
import com.system.doctorpatient.repository.DoctorRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("http://localhost:4200")
public class DoctorController {

	@Autowired
	private DoctorRepository dr;
	
	@GetMapping("/doctor")
	public List<Doctor> findAllDoctors()
	{
		return dr.findAll();
	}
	
	@GetMapping("/doctor/{id}")
	public ResponseEntity<Doctor> findDoctorById(@PathVariable Long id)
	{
		Doctor doctor = dr.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Doctor with id "+id+" doesn't exist"));
		return ResponseEntity.ok(doctor);
	}
	
	@PostMapping("/doctor")
	public Doctor addDoctor(@RequestBody Doctor doctor)
	{
		return dr.save(doctor);
	}
	
}
