package com.practice.service;

import org.springframework.stereotype.Service;

import com.practice.beans.Student;

@Service
public interface StudentService {

	Student createStudent(Student student);

	Student studentLogin(String email, String password);

	Student getStudentById(Integer id);

	Student updateStudent(Integer id, String password);

}
