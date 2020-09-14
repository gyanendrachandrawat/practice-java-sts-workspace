package com.practice.service;

import org.springframework.stereotype.Service;

import com.practice.beans.Teacher;

@Service
public interface TeacherService {

	Teacher createTeacher(Teacher teacher);

	Iterable<Teacher> getAllTeacher();

	Teacher getTeacherById(Integer id);

	Teacher teacherLogin(String email, String password);

}
