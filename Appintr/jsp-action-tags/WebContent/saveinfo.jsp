<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Info</title>
</head>
<body>
	<jsp:useBean id="studentBean" class="com.benilde.appintr.Student" scope="session" />
<%-- 	<jsp:setProperty property="firstName" name="studentBean" />
	<jsp:setProperty property="lastName" name="studentBean" />
	<jsp:setProperty property="email" name="studentBean" /> --%>
	<jsp:setProperty name="studentBean" property="*" />
		
	First Name: <jsp:getProperty property="firstName" name="studentBean"/>
	<br>
	Last Name: <jsp:getProperty property="lastName" name="studentBean"/>
	<br>
	Email : <jsp:getProperty property="email" name="studentBean"/>
	<a href="view-student-bean.jsp">Continue</a>
</body>
</html>