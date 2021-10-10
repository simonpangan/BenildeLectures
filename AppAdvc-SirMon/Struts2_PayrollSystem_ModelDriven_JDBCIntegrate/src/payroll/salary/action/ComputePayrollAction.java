package payroll.salary.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import payroll.salary.model.PayrollBean;

public class ComputePayrollAction extends ActionSupport implements ModelDriven<PayrollBean>{

	// SRP Principle
	// All java bean was removed and action methods are retain

	// aggregate relationship - Has a relationship
	private PayrollBean payroll;

	public ComputePayrollAction() {
		payroll = new PayrollBean();
	}
	
	public String execute() {
		return (payroll.insertRecord()) ? SUCCESS : ERROR;
	}

	@Override
	public void validate() {
		if (payroll.getEmpId().trim().length() == 0) {
			addFieldError("empId", "Invalid ID");
		} else if (payroll.getName().trim().length() == 0) {
			addFieldError("name", "Invalid Name");
		} else if (payroll.getHoursWorked() <= 0) {
			addFieldError("hoursWorked", "Must be positive");
		} else if (payroll.getHourlyRate() < 0) {
			addFieldError("hourlyRate", "Must be positive");
		}
	}

	public PayrollBean getPayroll() {
		return payroll;
	}

	public void setPayroll(PayrollBean payroll) {
		this.payroll = payroll;
	}

	@Override
	public PayrollBean getModel() {
		return payroll;
	}
}
