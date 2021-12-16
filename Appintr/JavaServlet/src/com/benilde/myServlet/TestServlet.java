package com.benilde.myServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet{

	private String msg;
	
	public void init()
	{
		msg = "Welcome to Java Servlet Programming";
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>"+ msg +"<h2>");
		out.println("</body></html>");
		
	}
}
