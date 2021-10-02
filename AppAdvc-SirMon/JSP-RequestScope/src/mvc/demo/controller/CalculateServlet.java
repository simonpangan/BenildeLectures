package mvc.demo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		request.setAttribute("grado" , grade);
		
		request.getRequestDispatcher("display.jsp").forward(request, response);
		
	}

}
