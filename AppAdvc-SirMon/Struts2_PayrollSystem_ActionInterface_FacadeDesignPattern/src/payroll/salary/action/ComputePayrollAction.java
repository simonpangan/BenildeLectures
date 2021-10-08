package payroll.salary.action;

import com.opensymphony.xwork2.Action;
import payroll.salary.utility.Facade;

public class ComputePayrollAction implements Facade, Action{

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
		this.basicPay = (this.hoursWorked <= 40) 
				? this.hoursWorked * this.hourlyRate
				: 40 * this.hourlyRate;
	}
	
	private void computeOvertimePay() {
		this.overtimePay = (this.hoursWorked > 40) 
				? (this.hoursWorked - 40) * this.hourlyRate * 1.5
				: 0;
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
	
	public String execute() {
		
		String status  = ERROR;
		
		if (this.empId.trim().length() > 0  
			&& this.name.trim().length() > 0
			&& this.hourlyRate > 0) 
		{
			process();
			status = SUCCESS;
		}
		
		return status;
	}
}
