package com.practice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.beans.Instructor;
import com.practice.service.InstructorService;

@RestController
@RequestMapping("/inst")
public class InstructorController {

	@Autowired
	private InstructorService instructorServiceImpl;

	@GetMapping("/instructors/all")
	public List<Instructor> getInstructors() {
		return instructorServiceImpl.getInstructors();
	}

	@GetMapping("/instructors/{id}")
	public ResponseEntity<Instructor> getInstructorById(@PathVariable(value = "id") Long instructorId) {
		return instructorServiceImpl.getInstructorById(instructorId);
	}

	@PostMapping("/instructors/create")
	public Instructor createInstructor(@RequestBody Instructor instructor) {
		return instructorServiceImpl.createInstructor(instructor);
	}

	@PutMapping("/instructors/update/{id}")
	public ResponseEntity<Instructor> updateInstructor(@PathVariable(value = "id") Long instructorId,
			@Valid @RequestBody Instructor instructorDetails) {
		return instructorServiceImpl.updateInstructor(instructorId, instructorDetails);
	}

	@DeleteMapping("/instructors/{id}")
	public String deleteInstructor(@PathVariable(value = "id") Long instructorId) {
		return instructorServiceImpl.deleteInstructor(instructorId);
	}

}
