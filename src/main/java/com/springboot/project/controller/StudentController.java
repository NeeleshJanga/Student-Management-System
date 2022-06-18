package com.springboot.project.controller;

import java.util.List;

import com.springboot.project.entity.Student;
import com.springboot.project.serviceImpl.StudentServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@GetMapping("/student/{id}")
	public String getStudent(@PathVariable("id") Long id) {
		return studentServiceImpl.findByStudentIf(id).toString();
	}
	
	@GetMapping("/students")
	public String getStudents(Model model) {
		model.addAttribute("students", studentServiceImpl.getStudents());
		return "students";
	}
	
	@PostMapping("/enter/student")
	public void postStudent(@RequestBody Student student) {
		studentServiceImpl.saveStudent(student);
	}

	@PostMapping("/enter/students")
	public void postStudents(@RequestBody List<Student> students) {
		studentServiceImpl.saveStudents(students);
	}
	
	@GetMapping("/student/new")
	public String addStudent(Model model) {
		model.addAttribute("student", new Student());
		return "create_student";
	}
	
	@PostMapping("/save/student")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentServiceImpl.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/update/student/{id}")
	public String updateStudent(@PathVariable("id") Long id, Model model) {
		model.addAttribute("student", studentServiceImpl.findByStudentIf(id));
		return "update_student";
	}
	
	@PostMapping("/save/student/{id}")
	public String updateStudent(@ModelAttribute("student") Student student, @PathVariable("id") Long id) {
		Student existingStudent = studentServiceImpl.findByStudentIf(id);
		studentServiceImpl.updateStudent(existingStudent, student);
		return "redirect:/students";
	}
	
	@GetMapping("/delete/student/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentServiceImpl.deleteStudent(id);
		return "redirect:/students";
	}
	
	@PostMapping("/save/new/student")
	public String saveNewStudent(@ModelAttribute("new_student") Student student) {
		studentServiceImpl.saveStudent(student);
		return "redirect:/";
	}
	
	@GetMapping("/update/student/password/{id}")
	public String updateStudentPassword(@PathVariable Long id, Model model) {
		model.addAttribute("new_student", new Student());
		model.addAttribute("student", studentServiceImpl.findByStudentIf(id));
		return "update_student_password";
	}
	
	@PostMapping("/save/student/password/{id}")
	public String saveStudentPassword(@PathVariable Long id, @ModelAttribute("new_student") Student student) {
		Student existingStudent = studentServiceImpl.findByStudentIf(id);
		
		existingStudent.setFirstName(existingStudent.getFirstName());
		existingStudent.setLastName(existingStudent.getLastName());
		existingStudent.setEmail(existingStudent.getEmail());
		existingStudent.setPassword(null);
		existingStudent.setPassword(student.getPassword());
		
		studentServiceImpl.saveStudent(existingStudent);
		
		return "redirect:/students";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
}
