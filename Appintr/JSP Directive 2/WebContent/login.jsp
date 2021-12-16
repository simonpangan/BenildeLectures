<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Demo</title>

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
  </div>
</nav>

<div class="container-fluid">
<%
// If a servlet or another page added an errorMessage Session object,
// then display it here, then make sure to remove it right afterwards.
String errorMessage = null;
if(session.getAttribute("errorMessage") != null)
	errorMessage = session.getAttribute("errorMessage").toString();

if(errorMessage != null) {
%>
	<div class="alert alert-danger">
		<b>Error!</b> <%= errorMessage %>
	</div>
<%
	session.removeAttribute("errorMessage");
}
%>

<%
// Same as above, but using Success color instead of Danger
String successMessage = null;
if(session.getAttribute("successMessage") != null)
	successMessage = session.getAttribute("successMessage").toString();

if(successMessage != null) {
%>
	<div class="alert alert-success">
		<b>Success!</b> <%= successMessage %>
	</div>
<%
	session.removeAttribute("successMessage");
}
%>

	<form method="post" action="Login">
		<div class="form-group">
			<label for="username">User name:</label>
			<input type="text" class="form-control" id="username" name="username" />
		</div>
		<div class="form-group">
			<label for="password">Password:</label>
			<input type="password" class="form-control" id="password" name="password" />
		</div>
		<div class="form-group">
			<button class="btn btn-primary" type="submit">Log In</button>
		</div>
	</form>
</div>

</body>
</html>