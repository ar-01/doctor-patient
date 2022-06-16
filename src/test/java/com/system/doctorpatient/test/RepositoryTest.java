package com.system.doctorpatient.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.system.doctorpatient.DoctorPatientApplication;
import com.system.doctorpatient.model.Doctor;
import com.system.doctorpatient.model.Patient;
import com.system.doctorpatient.repository.DoctorRepository;
import com.system.doctorpatient.repository.PatientRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DoctorPatientApplication.class)
@Transactional
public class RepositoryTest {

	@Autowired
	private DoctorRepository dr;
	
	@Autowired
	private PatientRepository pr;
	
	@Test
	public void findById_doctor()
	{
		Optional<Doctor> doctor = dr.findById(1L);
		assertEquals("Mohan Kumar", doctor.get().getName());
	}
	
	@Test
	public void findById_patient()
	{
		Optional<Patient> patient = pr.findById(1L);
		assertEquals("Kumar", patient.get().getName());
	}
	
	@Test
	@DirtiesContext
	public void add_doctor()
	{
		Optional<Doctor> doctor = dr.findById(1L);
		doctor.get().setName("Mohan Kumar - Updated");
		dr.save(doctor.get());
		assertEquals("Mohan Kumar - Updated", dr.findById(1L).get().getName());
	}
	
	@Test
	@DirtiesContext
	public void add_patient()
	{
		Optional<Patient> patient = pr.findById(1L);
		patient.get().setName("Kumar - Updated");
		pr.save(patient.get());
		assertEquals("Kumar - Updated", pr.findById(1L).get().getName());
	}
}
