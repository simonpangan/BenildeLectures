package com.benilde.myServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet{


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form action='Result'>");
		out.println("<p> Enter First Number: <input type='text'name='num1'/> </p>");
		out.println("<p> Enter Second Number: <input type='text'name='num2'/> </p>");
		out.println(" <input type='submit'value='Compute' />");
		out.println("</form>");
		out.println("</body></html>");
		
	}
}
