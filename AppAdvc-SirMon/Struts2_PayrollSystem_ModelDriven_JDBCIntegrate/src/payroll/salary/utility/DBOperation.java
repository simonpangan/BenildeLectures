package payroll.salary.utility;

public interface DBOperation {

	String INSERT_RECORD = "INSERT into payroll ("
			+ "empId"
			+ ",name"
			+ ",hoursWorked"
			+ ",hourlyRate"
			+ ",basicPay"
			+ ",overtimePay"
			+ ",grossPay"
			+ ",tax"
			+ ",netPay"
			+ ") VALUES (?,?,?,?,?,?,?,?,?)";
	
}
