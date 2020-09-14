package com.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.beans.Student;
import com.practice.repository.StudentRepository;

@Component("studentServiceImpl")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student studentLogin(String email, String password) {
		return studentRepository.findByEmailAndPassword(email,password);
	}

	@Override
	public Student getStudentById(Integer id) {
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public Student updateStudent(Integer id, String password) {
		Student student= studentRepository.findById(id).orElse(null);
		student.setPassword(password);
		studentRepository.save(student);
		return student;
	}
	
}
