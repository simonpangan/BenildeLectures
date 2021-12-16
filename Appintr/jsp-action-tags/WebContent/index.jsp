<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="MyBean" class="com.benilde.appintr.TestBean" scope="page" />
	<jsp:setProperty property="msg" name="MyBean" value="JSP Action Tag" />
	<h2><jsp:getProperty property="msg" name="MyBean"/></h2>
	
</body>
</html>