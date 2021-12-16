<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4 style="font-size: 20px">Input Grades for the following categories</h3>
	<hr>
	<h6 style="font-size: 15px">Fill out the information below</h6>
	<form action="midterm-grade-output.jsp">
		Class Participation: <input type="text" name="classParticipation" /> 
			<br/>
		Exercises: <input type="text" name="exercises" />
			<br/>
		Quizzes: <input type="text" name="quizzes" />
			<br/>
		Special Project: <input type="text" name="specialProject" />
			<br/>
		Midterm Exam: <input type="text" name="midtermExam" />
			<br/>
		<input type="submit" value="Compute Grade" />
	</form>
</body>
</html>