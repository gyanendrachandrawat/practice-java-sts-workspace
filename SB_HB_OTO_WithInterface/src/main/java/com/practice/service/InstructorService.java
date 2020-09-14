package com.practice.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.beans.Instructor;

@Service
public interface InstructorService {
	
	public List<Instructor> getInstructors();
	public ResponseEntity<Instructor> getInstructorById(Long instructorId);
	public Instructor createInstructor(Instructor instructor);
	public ResponseEntity<Instructor> updateInstructor(Long instructorId, @Valid Instructor instructorDetails);
	public String deleteInstructor(Long instructorId);
	
}
