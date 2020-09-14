package com.practice.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.practice.beans.AssignmentSubm;
import com.practice.repository.AssignmentSubmRepository;

@Component("assignmentSubmServiceImpl")
public class AssignmentSubmServiceImpl implements AssignmentSubmService {

	@Autowired
	AssignmentSubmRepository assignmentSubmRepository;

	String uploadFolder = "/home/aartek/Desktop/GyanendraSTS/POCtry1/assignmentFiles";

	@Override
	public AssignmentSubm createAssignmentSubm(Integer assignId, String assignTitle, MultipartFile file) {
		AssignmentSubm assignmentSubm = new AssignmentSubm();
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(uploadFolder + assignId.toString());
			Files.write(path, bytes);
			assignmentSubm.setAssignId(assignId);
			assignmentSubm.setAssignTitle(assignTitle);
			assignmentSubm.setfile(path.toString());
			assignmentSubmRepository.save(assignmentSubm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return assignmentSubm;
	}

	String submissionsFiles = "/home/aartek/Desktop/GyanendraSTS/POCtry1/assignmentSubmissions";

	@Override
	public AssignmentSubm submitAssignment(Integer assignId, MultipartFile assignStatus, Integer studentId) {
		AssignmentSubm assignmentSubm2 = assignmentSubmRepository.findById(assignId).orElse(null);
		try {
			byte[] bytes = assignStatus.getBytes();
			Path path = Paths.get(submissionsFiles + studentId.toString());
			Files.write(path, bytes);
			assignmentSubm2.setAssignStatus(path.toString());
			assignmentSubm2.setStudentId(studentId);
			assignmentSubmRepository.save(assignmentSubm2);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return assignmentSubm2;
	}

	@Override
	public AssignmentSubm createAssignmentSubm(MultipartFile file) {
		AssignmentSubm assignmentSubm = new AssignmentSubm();
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(uploadFolder +file.getOriginalFilename());
			Files.write(path, bytes);
			assignmentSubm.setfile("newFile");
			assignmentSubmRepository.save(assignmentSubm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return assignmentSubm;
	}

}
