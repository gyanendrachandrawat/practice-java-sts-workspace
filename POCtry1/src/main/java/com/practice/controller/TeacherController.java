package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.beans.Teacher;
import com.practice.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	@Qualifier("teacherServiceImpl")
	TeacherService teacherServiceImpl;
	
	@PostMapping("/create")
	public Teacher createTeacher(@RequestBody Teacher teacher) {
		return teacherServiceImpl.createTeacher(teacher);
	}
	
	@GetMapping("/getAll")
	public Iterable<Teacher> getAllTeacher(){
		return teacherServiceImpl.getAllTeacher();
	}
	
	@GetMapping("/getById/{id}")
	public Teacher getTeacherById(@PathVariable("id")Integer id) {
		return teacherServiceImpl.getTeacherById(id);
	}
	
	@PostMapping("teacherLogin")
	public Teacher teacherLogin(@RequestParam("email")String email, @RequestParam("password")String password) {
		return teacherServiceImpl.teacherLogin(email, password);
	}
	
}
