/**
 * 
 */
package com.example.repository;

import org.springframework.stereotype.Repository;

import com.example.model.Student;

/**
 * @author acer
 *
 */

@Repository

public class StudentRepository {

public Student getStudentByRollNo(int rollno) {
		
	
	
	
	
		Student stu = new Student(rollno,"Raj1", "Indore1");
		return stu;
	}
	
	
}
