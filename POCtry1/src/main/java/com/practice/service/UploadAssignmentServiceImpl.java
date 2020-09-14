//package com.practice.service;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.practice.beans.Assignment;
//import com.practice.repository.AssignmentRepository;
//
///*
// * implementation of upload assignment service interace 
// * */
//@Component("uploadAssignmentServiceImpl")
//public class UploadAssignmentServiceImpl implements UploadAssignmentService {
//	
//	@Autowired
//	AssignmentRepository assignmentRepository;
//	
//	String uploadFolder="/home/aartek/Desktop/GyanendraSTS/POCtry1/assignmentFiles";
//
//	@Override
//	public Assignment uploadFile(Integer teacherId, MultipartFile file) {
//		Assignment assignment=new Assignment();
//		try {
//			byte[] bytes=file.getBytes();
//			Path path=Paths.get(uploadFolder+teacherId.toString());
//			Files.write(path, bytes);
//			assignment.setAssignmentTitle(file.getOriginalFilename().toString());
//			assignment.setFileLocation(path.toString());
//			assignmentRepository.save(assignment);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return assignment;
//	}
//	
//}
