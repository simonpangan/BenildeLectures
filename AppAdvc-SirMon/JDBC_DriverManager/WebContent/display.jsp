<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id= "grado" scope= "session" class="mvc.demo.model.GradeBean" />  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ENTJAV MVC Model 2 Demo</title>
</head>
<body>
	<h2>MVC Model 2 Application Demo - session scope, dispatcher forward, and JSP getProterty</h2>
	<p>Student ID: <b><jsp:getProperty name="grado" property="id" /> </b></p>
	<p>Name: <b><jsp:getProperty name="grado" property="name" /> </b></p>
	<p>Midterm Grade: <b><jsp:getProperty name="grado" property="midterm" /> </b></p>
	<p>PreFinal Grade: <b><jsp:getProperty name="grado" property="preFinal" /> </b></p>
	<p>Remarks: <b><jsp:getProperty name="grado" property="remarks" /> </b></p>
</body>
</html>