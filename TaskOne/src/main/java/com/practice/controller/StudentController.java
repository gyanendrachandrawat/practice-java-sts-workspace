package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.Student;
//import com.practice.repository.StudentRepo;
import com.practice.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students/getall")
	public List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}
	
	@PostMapping("/students/createstudent")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent( student);
	}
	
	@PutMapping("/students/update/{sid}")
	public Student updateStudent(@PathVariable("sid")Integer sid  ,@RequestBody Student student) {
		return studentService.updateStudent(sid, student);
	}
	
	
	@GetMapping("/students/getonestudent/{sid}")
	public Student getOneStudent(@PathVariable("sid")Integer sid) {
		return studentService.getOneStudent(sid);
	}
	
	@DeleteMapping("/students/delete/{sid}")
	public Student deleteStudent(@PathVariable("sid")Integer sid) {
		return studentService.deleteStudent(sid);
	}
	
	
}
