package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

@RestController
@RequestMapping("/app")
public class AppController {
	
	Student st1 = new Student("kamal",21, "IT",3.1,"2020ICT001");
	
	@GetMapping("/student")
	public Student getStudent() {
		return st1;
	}

}
