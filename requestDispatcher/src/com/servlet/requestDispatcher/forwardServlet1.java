package com.servlet.requestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/forwardServlet1")
public class forwardServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String firstName = request.getParameter("firstName");
		RequestDispatcher rd = request.getRequestDispatcher("/fwServlet2"); // requestDispatcher can redirect the request only inside the server, to redirect the request outside the server sendRedirect is used 
		rd.forward(request, response);
		out.println(" _in forwardServlet1_ ");   //this will not be available in response display as this is forward
		out.close();
	}

}
