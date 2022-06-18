package com.springboot.project.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.springboot.project.entity.Student;
import com.springboot.project.repository.Repository;
import com.springboot.project.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceImpl implements StudentService{

	@Autowired
	private Repository repository;
	
	@Override
	public void saveStudent(Student student) {
		repository.save(student);
	}

	@Override
	public void saveStudents(List<Student> students) {
		repository.saveAll(students);
	}

	@Override
	public Student findByStudentIf(Long id) {
		Optional<Student> op = repository.findById(id);
		return op.get();
	}

	@Override
	public List<Student> getStudents() {
		List<Student> students = repository.findAll();
		return students;
	}

	@Override
	public void deleteStudent(Long id) {
		try {
			repository.deleteById(id);
		}catch(Exception e) {
			e.getMessage();
		}
	}

	@Override
	public Student updateStudent(Student existingStudent, Student student) {
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setPassword(student.getPassword());
		
		return repository.save(existingStudent);
	}

	@Override
	@Query(value = "UPDATE springboot.student SET password = 1? WHERE id = ?2", nativeQuery = true)
	public void changePassword(String password, Long id) {
		System.out.println(password);
	}

	@Override
	public void updateStudentPasswordById(Long id, Student student) {
		changePassword(student.getPassword(), id);
	}

	@Override
	public String searchStudent(Student student) {
		return null;
	}

}
