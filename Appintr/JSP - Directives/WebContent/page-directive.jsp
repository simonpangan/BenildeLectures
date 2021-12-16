<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.* , com.benilde.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p> The time on the server is <b> <%= new java.util.Date() %></b> </p>
	OR By using import 
	<p> The time on the server is <b> <%= new Date() %></b> </p> 
	
	<p> 10 plus 5  = <b> <%= com.benilde.MyUtility.sum(10,5) %></b> </p>
	OR By using import 
	<p> 10 plus 5  = <b> <%= MyUtility.sum(10,5) %></b> </p>
	
	<%! 
		MyUtility myUtil = new MyUtility();
	%>
	<p>10 multiplies by 2 is <%= myUtil.multiply(10,2) %></p>
	
	<br>
	<% 
		MyUtility myUtil = new MyUtility();
		out.println("10 multiplies by 2 is " + myUtil.multiply(10,2));
	%>
</body>
</html>