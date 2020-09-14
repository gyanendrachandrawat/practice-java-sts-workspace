package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Student;
import com.example.service.StudentService;

@Controller


public class HelloWorldController {

	@Autowired
	StudentService studentService; 
	

	@RequestMapping(value="/hello")
	
	public ModelAndView showMessage(){
		String message = "Welcome to Spring MVC!";
		System.out.println("in controller");

		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		return mv;
	}
	
	
	@RequestMapping(value="/getStudentDeatil")
	public ModelAndView showStudentDetail(@RequestParam("rollno") int rollno) {
		
		ModelAndView mv = new ModelAndView("studentDetail");
	
		Student studetail =  studentService.getStudentByRollNo(rollno);
	

		mv.addObject("studentDetail",studetail);
		
		return mv;
	}
}
