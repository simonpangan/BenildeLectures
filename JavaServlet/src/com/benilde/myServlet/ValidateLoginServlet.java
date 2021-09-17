package com.benilde.myServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ValidateLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h1> Login Result </h1>");
		out.println("<hr>");	
		
		if(username.equals("csb") & password.equals("benilde")) {
			out.println("<h3> Login Successfull </h3>");
		}
		else {
			out.println("<h3> Invalid User Name / Passwords </h3>");
			out.println("<br> <a href='Login'> Return to Login Page </a>");
		}
		
		out.println("</body></html>");
		
	}

}
