package mvc.demo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

import mvc.demo.model.GradeBean;
/**
 * Servlet implementation class ListAllRecords
 */
@WebServlet("/ListRecords")
public class ListAllRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ResultSet records = new GradeBean().getAllRecords();
			
		request.setAttribute("dbRecords", records);
		
		request.getRequestDispatcher("listrecords.jsp").forward(request, response);
		
	}
}
