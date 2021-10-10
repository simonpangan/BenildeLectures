package payroll.salary.model;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

import payroll.salary.utility.DBOperation;
import payroll.salary.utility.Facade;

public class PayrollBean implements Facade, DBOperation {

	private String empId;
	private String name;
	private int hoursWorked;
	private double hourlyRate;

	private double basicPay;
	private double overtimePay;
	private double grossPay;
	private double tax;
	private double netPay;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public double getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(double basicPay) {
		this.basicPay = basicPay;
	}

	public double getGrossPay() {
		return grossPay;
	}

	public void setGrossPay(double grossPay) {
		this.grossPay = grossPay;
	}

	public double getOvertimePay() {
		return overtimePay;
	}

	public void setOvertimePay(double overtimePay) {
		this.overtimePay = overtimePay;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getNetPay() {
		return netPay;
	}

	public void setNetPay(double netPay) {
		this.netPay = netPay;
	}

	private void computeBasicPay() {
		this.basicPay = (this.hoursWorked <= 40) ? this.hoursWorked * this.hourlyRate : 40 * this.hourlyRate;
	}

	private void computeOvertimePay() {
		this.overtimePay = (this.hoursWorked > 40) ? (this.hoursWorked - 40) * this.hourlyRate * 1.5 : 0;
	}

	private void computeGrossPay() {
		this.grossPay = this.basicPay * this.overtimePay;
	}

	private void computeWithHoldingTax() {
		this.tax = this.grossPay * 0.1;
	}

	private void computeNetPay() {
		this.netPay = this.grossPay - this.tax;
	}

	@Override
	public void process() {
		this.computeBasicPay();
		this.computeOvertimePay();
		this.computeGrossPay();
		this.computeWithHoldingTax();
		this.computeNetPay();
	}

	private Connection getConnection() throws SQLException, InvocationTargetException {
		
		Connection connection = null;
		try {

//			Context initContext = new InitialContext();
//			Context envContext  = (Context)initContext.lookup("java:/comp/env");
//			DataSource ds = (DataSource)envContext.lookup("jdbc/APPACVC");
//			connection = ds.getConnection();
	
			connection = 
					((DataSource)InitialContext.doLookup("java:/comp/env/jdbc/APPACVC"))
					.getConnection();
		
			if (connection != null) {
				System.out.println("Connection is valid");
			} else {
				System.err.println("connection is not valid");
			}
			
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		} catch(NamingException sqle) {
			System.err.println(sqle.getMessage());
		} 
		return connection;
	}
	

	public boolean insertRecord() throws InvocationTargetException {

		boolean isSuccess = false;

		Connection connection = null;
		try {

			connection = getConnection();
			
			PreparedStatement prep = connection.prepareStatement(DBOperation.INSERT_RECORD);
			prep.setString(1, this.empId);
			prep.setString(2, this.name);
			prep.setInt(3, this.hoursWorked);
			prep.setDouble(4, this.hourlyRate);
			prep.setDouble(5, this.basicPay);
			prep.setDouble(6, this.overtimePay);
			prep.setDouble(7, this.grossPay);
			prep.setDouble(8, this.tax);
			prep.setDouble(9, this.netPay);

			prep.executeUpdate();
			connection.commit();

			isSuccess = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;
	}
}
