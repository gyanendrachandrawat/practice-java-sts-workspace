package com.DBspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DBspring.repository.*;
import com.DBspring.model.*;

@Service
public class DBspringService {

	@Autowired
	DBspringRepository DBspringRepository;
	
	public Student getStudentByRollno(int rollno)
	{
		Student stu=DBspringRepository.getStudentByRollno(rollno);
		return stu;
	}
	
	
	/*
	public DBspringService() {
		
	}
	*/
}
