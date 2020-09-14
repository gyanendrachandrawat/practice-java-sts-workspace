package com.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.beans.Teacher;
import com.practice.repository.TeacherRepository;

@Component("teacherServiceImpl")
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	TeacherRepository teacherRepository;

	@Override
	public Teacher createTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public Iterable<Teacher> getAllTeacher() {
		return teacherRepository.findAll();
	}

	@Override
	public Teacher getTeacherById(Integer tId) {
		return teacherRepository.findById(tId).orElse(null);
	}

	@Override
	public Teacher teacherLogin(String email, String password) {
		return teacherRepository.findByEmailAndPassword(email, password);
	}

}
