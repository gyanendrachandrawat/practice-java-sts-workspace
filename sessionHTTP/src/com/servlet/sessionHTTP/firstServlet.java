package com.servlet.sessionHTTP;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/firstServlet")
public class firstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in firstServlet");
		HttpSession session = request.getSession();
		String uName1=request.getParameter("uName");
		//String Upass1=request.getParameter("uPass");
		session.setAttribute("str1" , uName1);
		//session.setAttribute("str2", Upass1);
		response.sendRedirect("/servlet2");
	}

}
