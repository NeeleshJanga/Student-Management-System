package com.springboot.project.controller;

import com.springboot.project.entity.Student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		return "home";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("new_student", new Student());
		return "register";
	}
	
}
