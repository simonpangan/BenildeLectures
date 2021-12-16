<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3> Login Result</h3>
<%! 
	String myUserName = "Benilde";
	String myPassword = "Password";
%>
	
<%
	String username = request.getParameter("userName");
	String password = request.getParameter("password");
	
	if(myUserName.equals(username) && myPassword.equals(password))
	{
		out.println("Login Successful");
	}
	else
	{
		out.println("Login Failed");
	}
%>

</body>
</html>