package mvc.demo.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.demo.model.GradeBean;



public class CalculateServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String studentID = request.getParameter("studentID");
		String name = request.getParameter("name");
		double midterm = Double.parseDouble(request.getParameter("midterm"));	
		double preFinal = Double.parseDouble(request.getParameter("preFinal"));	
		
		GradeBean grade = new GradeBean();
		grade.setId(studentID);
		grade.setName(name);
		grade.setMidterm(midterm);
		grade.setPreFinal(preFinal);
		grade.computeFinalGrade();
		grade.determineRemarks();
		
		// test if connection is good
	
		try {
			grade.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		HttpSession session = request.getSession();
		session.setAttribute("grado" , grade);
		
		request.getRequestDispatcher("display.jsp").forward(request, response);
		
	}

}
