<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payroll Salary Form</title>
</head>
<body>
	<h2>Payroll Salary HTML OGNL Input Form</h2>
	<s:form action="computepayroll.action" method="POST">
		<s:textfield label="Enter Employee ID" key="empId" size="15"></s:textfield>
		<s:textfield label="Enter Name" key="name" size="35"></s:textfield>
		<s:textfield label="Enter Hours Worked" key="hoursWorked" ></s:textfield>
		<s:textfield label="Enter Hourly Rate" key="hourlyRate" ></s:textfield>
		<s:submit value="Compute Salary"></s:submit>
	</s:form>
</body>
</html>