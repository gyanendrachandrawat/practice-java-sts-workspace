package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.modal.Student;

@Controller
public class HelloWorldController {

	

	@RequestMapping(value="/hello")
	
	public ModelAndView showMessage(){
		//String message = "Welcome to Spring MVC!";
		System.out.println("in controller");

		//ModelAndView mv = new ModelAndView("helloworld");
		//mv.addObject("message", message);
		ModelAndView av=new ModelAndView("student");
		Student stu=new Student("gyan","email",4566);
		
		av.addObject("Student",stu);
		
		
		return av;
	
	}
	
}
