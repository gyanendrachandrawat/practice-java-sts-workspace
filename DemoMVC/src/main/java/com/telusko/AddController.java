package com.telusko;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddController {
	@RequestMapping("/add")
	public String add() {
		//System.out.println("AddController.add()");
		return "display.jsp";
	}
}