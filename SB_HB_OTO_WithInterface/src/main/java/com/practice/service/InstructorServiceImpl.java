package com.practice.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.practice.beans.Instructor;
import com.practice.beans.InstructorDetail;
import com.practice.repository.InstructorRepository;

@Component(value = "instructorServiceImpl")
public class InstructorServiceImpl implements InstructorService {
	
	@Autowired
	private InstructorRepository instructorRepository;

	@Override
	public List<Instructor> getInstructors() {
		return instructorRepository.findAll();
	}

	@Override
	public ResponseEntity<Instructor> getInstructorById(Long instructorId) {
		Instructor instructor = instructorRepository.findById(instructorId).orElse(null);
		return ResponseEntity.ok().body(instructor);
	}

	@Override
	public Instructor createInstructor(Instructor instructor) {
		InstructorDetail instructorDetail = new InstructorDetail(instructor.getInstructorDetail().getYoutubeChannel(),
				instructor.getInstructorDetail().getHobby());
		instructor.setInstructorDetail(instructorDetail);
		return instructorRepository.save(instructor);
	}

	@Override
	public ResponseEntity<Instructor> updateInstructor(Long instructorId, @Valid Instructor instructorDetails) {
		Instructor instructor = instructorRepository.findById(instructorId).orElse(null);
		instructor.setEmail(instructorDetails.getEmail());
		Instructor newInstructor = instructorRepository.save(instructor);
		return ResponseEntity.ok().body(newInstructor);
	}

	@Override
	public String deleteInstructor(Long instructorId) {
		Instructor instructor = instructorRepository.getOne(instructorId);
		String tempId = instructor.getId().toString();
		instructorRepository.delete(instructor);
		return "deleted : " + tempId;
	}

}
