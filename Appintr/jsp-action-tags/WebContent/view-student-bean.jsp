<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="studentBean" class="com.benilde.appintr.Student" scope="session" />
	
	First Name: <jsp:getProperty property="firstName" name="studentBean"/>
	<br>
	Last Name: <jsp:getProperty property="lastName" name="studentBean"/>
	<br>
	Email : <jsp:getProperty property="email" name="studentBean"/>
</body>
</html>