<jsp:useBean id="dbRecords" type="java.sql.ResultSet" scope="request"/> 
<!DOCTYPE html>
<html lang="en">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel=icon href="imgs/icon.png" sizes="16x16" type="image/png">

	<title>List Records </title>
</head>
<body>
	<h2> MVC Model 2 Application Demo </h2>
	
		<table border="1px" cellpadding="1px" cellspacing="1px">
			<tr>
				<th>#</th>
				<th>Student ID</th>
				<th>Name</th>
				<th>Midterm Grade</th>
				<th>Pre-Final Grade</th>
				<th>Final Grade</th>
				<th>Remarks</th>
			<tr>
			<% while (dbRecords.next()) { %>
			<tr align="center">
		
				<td> <%= dbRecords.getInt("pkid") %> </td>
				<td> <%= dbRecords.getString("studentId") %> </td>
				<td> <%= dbRecords.getString("name") %> </td>
				<td> <%= dbRecords.getDouble("midterm") %> </td>
				<td> <%= dbRecords.getDouble("preFinal") %> </td>
				<td> <%= dbRecords.getDouble("finalGrade") %> </td>
				<td> <%= dbRecords.getString("remarks") %> </td>
			</tr> 
			<% } %>
	</table>
</body>
</html>