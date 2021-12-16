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
	int sum(int a, int b ) {
		int total = a + b;
		return total;
	}
%>
	
<%
	int num1 = Integer.parseInt(request.getParameter("firstNum"));
	int num2 = Integer.parseInt(request.getParameter("secondNum"));
	
	out.println("The sum of JSP expression is " + num1 +  " is " +  num2 
				+ " = " + sum(num1,num2));
%>

<p> The sum of JSP expression is <%= num1 %> is <%= num2 %> = <%= sum(num1,num2) %></p>
	
</body>
</html>