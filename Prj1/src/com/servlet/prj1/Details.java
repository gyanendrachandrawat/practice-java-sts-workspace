package com.servlet.prj1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;



public class Details extends HttpServlet {
	
       
   

	
	
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String userName=request.getParameter("userName");
		String userPass=request.getParameter("userPass");
		
		String adminUsername= getServletConfig().getInitParameter("adminUsername");
		String adminPassword= getServletConfig().getInitParameter("adminPassword");
		
		if(adminUsername.equals(userName) && adminPassword.equals(userPass)) {
			String Name=getServletContext().getInitParameter("Name");
			out.println("name is : " +Name);
		}
		else {
			out.println("please check your username and password");
		}
			
	}

}
