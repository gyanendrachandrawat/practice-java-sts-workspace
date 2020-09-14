package com.DBspring.repository;

import org.springframework.stereotype.Repository;

import com.DBspring.model.*; 

@Repository
public class DBspringRepository {

	public Student getStudentByRollno(int rollno)
	{
		Student stu=new Student(rollno,"StudentName","StudentAddress");
		return stu;
	}
	

	/*public DBspringRepository() {
	
	}*/

}
