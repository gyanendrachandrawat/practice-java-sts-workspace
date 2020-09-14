package com.DBspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DBspring.model.Student;
import com.DBspring.service.DBspringService;

@Controller


public class DBspringController {
	
	/*
	//test start
	
	@RequestMapping(value="/message")
	public ModelAndView testmessage() {
		String message="test message from controller";
		System.out.println("test message from controller");
		ModelAndView mvs=new ModelAndView("studentDetail");
		mvs.addObject("message", message);
		return mvs;
				
		
		
	}	
	//test end
	
*/
	@Autowired
	DBspringService DBspringService;
	
	@RequestMapping(value="/getStudentDetail")
	public ModelAndView getStudentDetail(@RequestParam("rollno") int rollno)
	{
		
		//String msg="in controller";
		//System.out.println("in controller");
		//ModelAndView mvmsg=new ModelAndView("studentDetail");
		//mvmsg.addObject("msg",msg);
		
		
		ModelAndView mv=new ModelAndView("studentDetail");
		
		Student studetail=DBspringService.getStudentByRollno(rollno);
		
		mv.addObject("studentDetail",studetail);
		//return mvmsg;
		return mv;
		
	}
	
	

}
