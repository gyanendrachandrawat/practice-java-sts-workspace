package com.servlet.contextConfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showDetails")
public class showDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String userid=getServletConfig().getInitParameter("userid"); //value of servlet config from web.xml
		String userpass=getServletConfig().getInitParameter("userpass");
		
		if ( userid.equals(userName) && userpass.equals(password) ) {
			String name=getServletContext().getInitParameter("name"); //value of servlet context from web.xml
			out.println("name is : "+name);
		}
		else{
			out.println("check id and password");
		}
	}

}
