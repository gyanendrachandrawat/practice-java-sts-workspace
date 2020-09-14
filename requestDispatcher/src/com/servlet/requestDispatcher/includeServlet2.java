package com.servlet.requestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/includeServlet2")
public class includeServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String str11=request.getParameter("lastName");
		String str22="includeServlet2";
		out.println(" _in includeServlet2_ ");
		out.println(" _received from includeServlet1 lastName : "+str11+"_ ");
		out.println(" _response from includeServlet2 : "+str22+"_ ");
	}

}
