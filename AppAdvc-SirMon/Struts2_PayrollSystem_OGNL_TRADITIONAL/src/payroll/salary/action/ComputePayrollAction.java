package payroll.salary.action;

public class ComputePayrollAction {

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


	public void	computeBasicPay() {
		this.basicPay = (this.hoursWorked <= 40) 
				? this.hoursWorked * this.hourlyRate
				: 40 * this.hourlyRate;
	}
	
	public void computeOvertimePay() {
		this.overtimePay = (this.hoursWorked > 40) 
				? (this.hoursWorked - 40) * this.hourlyRate * 1.5
				: 0;
	}
	
	public void computeGrossPay() {
		this.grossPay = this.basicPay * this.overtimePay;
	}
	
	public void computeWithHoldingTax() {
		this.tax = this.grossPay * 0.1;
	}
	
	public void computeNetPay() {
		this.netPay = this.grossPay - this.tax;
	}
		
	//Execute Method
	
	public String execute() {
		String status  = "error";
		
//		this.empId = "123123";
//		this.name = "Simon Pangan";
//		this.hoursWorked = 90;
//		this.hourlyRate = 5000;
			
		if (this.empId.trim().length() > 0  
			&& this.name.trim().length() > 0
			&& this.hourlyRate > 0) 
		{
			this.computeBasicPay();
			this.computeOvertimePay();
			this.computeGrossPay();
			this.computeWithHoldingTax();
			this.computeNetPay();
			
			System.out.println("Employeed Id: " + getEmpId());
			System.out.println("Name: " + getName());
			System.out.println("Hours Worked: Php " + getHoursWorked());
			System.out.println("Hours Rate: Php" + getHourlyRate());
			System.out.println("Basic Pay: Php " + getBasicPay());
			System.out.println("Overtime Pay: Php " + getOvertimePay());
			System.out.println("Gross Pay: Php " + getGrossPay());
			System.out.println("Withholding Pay: Php " + getTax());
			System.out.println("Net Pay: Php " + getNetPay());
		
			status = "success";
		}
		return status;
	}


	public double getOvertimePay() {
		return overtimePay;
	}


	public void setOvertimePay(double overtimePay) {
		this.overtimePay = overtimePay;
	}
}
