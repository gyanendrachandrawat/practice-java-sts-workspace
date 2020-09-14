package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Student;
import com.example.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public Student getStudentByRollNo(int rollno) {
		
		

		Student stu = studentRepository.getStudentByRollNo(rollno);
		//chirag
		/*
		Employee emp=employeeRepository.gteEmployeeeDetail(empno);
		int salary=emp.getSalary();
		salary pe 15% bonus
		salary=salary+15%;
		emp.setSalary(salary);
		return emp;
		 */
		
		return stu;
	}
	
	
}
