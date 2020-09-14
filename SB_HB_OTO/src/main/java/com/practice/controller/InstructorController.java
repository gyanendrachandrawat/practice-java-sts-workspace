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
	private InstructorService instructorService;
//	private InstructorRepository instructorRepository;

	@GetMapping("/instructors/all")
	public List<Instructor> getInstructors() {
		return instructorService.getInstructors();
//		return instructorRepository.findAll();
	}

	@GetMapping("/instructors/{id}")
	public ResponseEntity<Instructor> getInstructorById(@PathVariable(value = "id") Long instructorId) {
		return instructorService.getInstructorById(instructorId);
//		Instructor instructor=instructorRepository.findById(instructorId).orElse(null);
//		return ResponseEntity.ok().body(instructor);
	}

	@PostMapping("/instructors/create")
	public Instructor createInstructor(@RequestBody Instructor instructor) {
		return instructorService.createInstructor(instructor);
//		InstructorDetail instructorDetail1=new InstructorDetail(instructor.getInstructorDetail().getYoutubeChannel(),instructor.getInstructorDetail().getHobby());
//		instructor.setInstructorDetail(instructorDetail1);
//		instructorRepository.save(instructor);
//		return instructor;
	}

	@PutMapping("/instructors/update/{id}")
	public ResponseEntity<Instructor> updateInstructor(@PathVariable(value = "id") Long instructorId,
			@Valid @RequestBody Instructor instructorDetails) {
		return instructorService.updateInstructor(instructorId, instructorDetails);
//		Instructor instructor=instructorRepository.findById(instructorId).orElse(null);
//		instructor.setEmail(instructorDetails.getEmail());
//		Instructor newInstructor=instructorRepository.save(instructor);
//		return ResponseEntity.ok().body(newInstructor);
	}

	@DeleteMapping("/instructors/{id}")
	public String deleteInstructor(@PathVariable(value = "id") Long instructorId) {
		return instructorService.deleteInstructor(instructorId);
//		Instructor instructor=instructorRepository.getOne(instructorId);
//		instructorRepository.delete(instructor);
	}

}
