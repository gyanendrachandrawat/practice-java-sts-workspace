//package com.practice.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.practice.beans.Assignment;
//import com.practice.service.UploadAssignmentService;
//
///*
// * upload assignment controller
// * controller to upload the assignment file 
// * */
//@RestController
//@RequestMapping("/uploadAssignment")
//public class UploadAssignmentController {
//	
//	@Autowired
//	@Qualifier("uploadAssignmentServiceImpl")
//	UploadAssignmentService uploadAssignmentServiceImpl;
//	
//	String returnMessage;
//	
//	/*
//	 * upload Assignment method controller  
//	 * */
//	@PostMapping("/uploadFile/{teacherId}")
//    public Assignment uploadFile(@PathVariable("teacherId")Integer teacherId, @RequestBody MultipartFile file) {
//		return uploadAssignmentServiceImpl.uploadFile(teacherId, file);
//    }
//
//}
