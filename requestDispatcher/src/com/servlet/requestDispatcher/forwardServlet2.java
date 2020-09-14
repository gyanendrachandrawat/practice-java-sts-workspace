package com.servlet.requestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;
//import javax.servlet.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forwardServlet2")
public class forwardServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String str1 = request.getParameter("firstName");
		String str2 = "forwardServlet2";
		out.println(" _in forwardServlet2_ ");
		out.println(" _received from forwardServlet1 firstName : "+str1+"_ ");
		out.println(" _response from forwardServlet2 : "+str2+"_ ");
	}

}
