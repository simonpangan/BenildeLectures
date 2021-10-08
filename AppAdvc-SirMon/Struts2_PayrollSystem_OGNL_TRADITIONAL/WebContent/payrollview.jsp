<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%--  USING OGNL tag library in strut 2 --%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compute Salary Computation Details</title>
</head>
<body>

	<h2>Display Salary Computed Details JSP Expression Language</h2>
	<p>Employee ID: <b> ${empId} </b></p>
	<p>Name: <b> ${name} </b></p>
	<p>Hours Worked: <b> ${hoursWorked} </b></p>
	<p>Hourly Rate: <b>Php ${hourlyRate} </b></p>
	<p>Basic Pay: <b>Php ${basicPay} </b></p>
	<p>Overtime Pay: <b>Php ${overtimePay} </b></p>
	<p>Gross Pay: <b>Php ${grossPay} </b></p>
	<p>Tax Pay: <b>Php ${tax} </b></p>
	<p>NET PAY : <b>Php ${netPay} </b></p>
	<hr/>
	
	<h2>Display Salary Computed Details Using OGNL</h2>
	<p>Employee ID: <b> <s:property value="empId"/> </b></p>
	<p>Name: <b> <s:property value="name"/> </b></p>
	<p>Hours Worked: <b> <s:property value="hoursWorked"/> ${hoursWorked} </b></p>
	<p>Hourly Rate: <b>Php <s:property value="hourlyRate"/> ${hourlyRate} </b></p>
	<p>Basic Pay: <b>Php <s:property value="basicPay"/>${basicPay} </b></p>
	<p>Overtime Pay: <b>Php <s:property value="overtimePay"/> </b></p>
	<p>Gross Pay: <b>Php <s:property value="grossPay"/> </b></p>
	<p>Tax Pay: <b>Php <s:property value="tax"/></b></p>
	<p>NET PAY : <b>Php <s:property value="netPay"/> </b></p>
	<hr/>
	<form action="index.jsp">
		<input type="submit" value="<< GO BACK >>" />
	</form>
</body>
</html>