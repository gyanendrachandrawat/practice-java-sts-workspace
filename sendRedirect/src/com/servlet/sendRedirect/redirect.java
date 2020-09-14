package com.servlet.sendRedirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/redirect")
public class redirect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String userId=getServletConfig().getInitParameter("userId");
		String userPassword=getServletConfig().getInitParameter("userPassword");
		if(userId.equals(id) && userPassword.equals(password)){
			response.sendRedirect("https://www.facebook.com"); //sendRedirect can redirect the request inside and outside the server both, but requestDispatcher can redirect the request the request only inside the server. 
		}
		else{
			out.println("please check login details");
		}
	}

}
