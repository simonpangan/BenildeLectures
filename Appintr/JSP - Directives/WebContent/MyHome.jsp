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
		int a = 0;
		int b = 0;
		
		int sum(int a, int b ) {
			int total = a + b;
			return total;
		}
	%>
	<h3>Welcome to Java Web Development</h3>
	
	<%-- This is a a comment --%>
	
	<p> Tasdasdasdas </p>
	
	The sum of 10 + 5 is <%= sum(10,5) %>
	
	<form action="result.jsp">
		First Number: <input type="text" name="firstNum" />
		Second Number: <input type="text" name="secondNum" />
		
		<input type="submit" value="Add" />
	</form>
	
</body>
</html>