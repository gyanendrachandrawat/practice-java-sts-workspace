package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.practice.beans.AssignmentSubm;
import com.practice.service.AssignmentSubmService;

@RestController
@RequestMapping("/submissions")
public class AssignmentSubmController {

	@Autowired
	@Qualifier("assignmentSubmServiceImpl")
	AssignmentSubmService assignmentSubmServiceImpl;

	@PostMapping("/create")
	public AssignmentSubm createAssignmentSubm(/*@RequestParam("assignId") Integer assignId,
			@RequestParam("assignTitle") String assignTitle, */@RequestParam("file") MultipartFile file) {
		return assignmentSubmServiceImpl.createAssignmentSubm(/*assignId, assignTitle, */file);
	}

//	String result;
	@PutMapping("/submitAssignment")
	public AssignmentSubm submitAssignment(@RequestParam("assignId") Integer assignId,
			@RequestParam("assignStatus") MultipartFile assignStatus, @RequestParam("studentId") Integer studentId) {
		return assignmentSubmServiceImpl.submitAssignment(assignId, assignStatus, studentId);
	}

}
