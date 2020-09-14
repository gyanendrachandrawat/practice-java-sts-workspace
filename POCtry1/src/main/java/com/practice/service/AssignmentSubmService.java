package com.practice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.practice.beans.AssignmentSubm;

@Service
public interface AssignmentSubmService {

	AssignmentSubm createAssignmentSubm(Integer assignId, String assignTitle, MultipartFile file);

	AssignmentSubm submitAssignment(Integer assignId, MultipartFile assignStatus, Integer studentId);

	AssignmentSubm createAssignmentSubm(MultipartFile file);

}
