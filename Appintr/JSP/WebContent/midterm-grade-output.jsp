<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%!
	double classParticipation;
	double exercises;
	double quizzes;
	double specialProject;
	double midtermExam;
	
	public double  computeMidtermGrade()
	{
		double sum = 0;
		sum = this.classParticipation * .10;
		sum = sum + (this.exercises * .20);
		sum = sum + (this.quizzes * .25);
		sum = sum + (this.specialProject * .20);
		sum = sum + (this.midtermExam * .25);
		
		return sum;
	}
%>

<%
	this.classParticipation = Double.parseDouble(request.getParameter("classParticipation"));
	this.exercises = Double.parseDouble(request.getParameter("exercises"));
	this.quizzes = Double.parseDouble(request.getParameter("quizzes"));
	this.specialProject = Double.parseDouble(request.getParameter("specialProject"));
	this.midtermExam = Double.parseDouble(request.getParameter("midtermExam"));

	out.println("Class Participation: " + this.classParticipation);
	out.println("<br/>");
	out.println("Exercises: " + this.exercises);
	out.println("<br/>");
	out.println("Quizzes: " + this.quizzes);
	out.println("<br/>");
	out.println("Special Project: " + this.specialProject);
	out.println("<br/>");
	out.println("Midterm Exam: " + this.midtermExam);
	out.println("<br/>");
	out.println("<br/>");

	String computedGrade =  String.format("%.2f", computeMidtermGrade());
	out.println("<b> Midterm Exam: " + computedGrade + " <b/>");
%>
</body>
</html>