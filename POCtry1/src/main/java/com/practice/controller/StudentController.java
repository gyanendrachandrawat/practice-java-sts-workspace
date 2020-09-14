package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.beans.Student;
import com.practice.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	@Qualifier("studentServiceImpl")
	StudentService studentServiceImpl;
	
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return studentServiceImpl.createStudent(student);
	}
	
	@PostMapping("/studentLogin")
	public Student studentLogin(@RequestParam("email")String email, @RequestParam("password")String password) {
		return studentServiceImpl.studentLogin(email,password);
	}
	
	@GetMapping("/getById/{id}")
	public Student getStudentById(@PathVariable("id")Integer id) {
		return studentServiceImpl.getStudentById(id);
	}
	
	@PutMapping("/update/{id}")
	public Student updateStudent(@PathVariable("id")Integer id, @RequestParam("password")String password) {
		return studentServiceImpl.updateStudent(id, password);
	}
	
}
