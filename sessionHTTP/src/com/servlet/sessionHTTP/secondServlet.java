package com.servlet.sessionHTTP;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/secondServlet")
public class secondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		String uName2 = session.getAttribute("str1").toString();
		//String uPass2 = session.getAttribute("str2").toString();
		String userName = getServletConfig().getInitParameter("userName");
		//String userPass = getServletConfig().getInitParameter("userPass");
		if(userName.equals("uName2") /*&&userPass.equals(uPass2) */ ){
			System.out.println("logged in");
			String name = getServletConfig().getInitParameter("name");
			out.println("welcome "+name+" you are logged in.");
			out.println("<br>");
			//out.println("<a href="https://www.facebook.com">click to go to facebook page</a>");
		}
		else{
			System.out.println("check problem");
			out.println("check input");
		}
		
	}

}