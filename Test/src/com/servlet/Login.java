package com.servlet;

import java.io.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		out.println("Login servlet");
		
		String uName=getServletConfig().getInitParameter("uName");
		String uPassword=getServletConfig().getInitParameter("uPassword");
		
		String userName=request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
		
		if(uName.equals(userName) && uPassword.equals(userPassword))
		{
			out.println("you are logged in");
			String RollNo=getServletContext().getInitParameter("rollNo");
			out.println("Your Roll-No is : "+RollNo);
		}
		else
		{
			out.println("please check username and password");
		}
		
	}

}
