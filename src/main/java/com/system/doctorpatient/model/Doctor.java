package com.system.doctorpatient.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Doctor {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private int age;
	private String gender;
	private String specialization;
	
	protected Doctor() {}
	
	public Doctor(String name, int age, String gender, String specialization) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.specialization = specialization;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", specialization="
				+ specialization + "]";
	}
	
}
