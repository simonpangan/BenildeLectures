<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
// Check session if there is a logged in user.
// If none, then redirect back to login page.
if(session.getAttribute("username") == null) {
	session.setAttribute("errorMessage", "Your session has expired. Please login again.");
	response.sendRedirect("login.jsp");
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 

</head>
<body>
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">Login Demo</a>
	    </div>
	    <ul class="nav navbar-nav navbar-right">
	    	<li><p class="navbar-text">Welcome <%= session.getAttribute("username").toString() %>!</p></li>
	    	<li><a href="Logout">Log Out</a></li>
	    </ul>
	  </div>
	</nav>
	
	<div class="container-fluid">
		<h1>Main Page</h1>
		<p>Welcome to the main page!</p>	
	</div>
</body>
</html>