package com.springboot.project.service;

import java.util.List;

import com.springboot.project.entity.Student;

import org.springframework.stereotype.Service;

@Service
public interface StudentService {

	void saveStudent(Student student);

	void saveStudents(List<Student> students);

	Student findByStudentIf(Long id);

	List<Student> getStudents();

	void deleteStudent(Long id);

	Student updateStudent(Student existingStudent, Student student);

	void changePassword(String password, Long id);

	void updateStudentPasswordById(Long id, Student student);

	String searchStudent(Student student);

}
