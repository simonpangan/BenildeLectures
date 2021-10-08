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
	<%--response.sendRedirect("computepayroll"); --%>
	
	<!-- <h2>Payroll Salary HTML Traditional Input Form</h2>
	<form action="computepayroll" method="POST">
		<p>
			Enter Employee ID: <input type="text" name='empId' size='15' />
		</p>
		<p>
			Enter Name: <input type="text" name='name' size='35' />
		</p>
		<p>
			Enter Hours Work: <input type="text" name='hoursWorked'/>
		</p>
		<p>
			Enter Hourly Rate: <input type="text" name='hourlyRate' />
		</p>
		<p>
			<input type="submit" value='Comput Salary' />			
		</p>
		<p>
			<input type="reset" value='Reset' />			
		</p>
	</form>  -->
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