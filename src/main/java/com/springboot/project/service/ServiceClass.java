package com.springboot.project.service;

import com.springboot.project.entity.Student;

import org.springframework.stereotype.Service;

@Service
public class ServiceClass {
	
	private Student student;
	
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(String firstName, String lastName, String email) {
		student = new Student(firstName, lastName, email);
	}
}
