package com.benilde.lecture;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped

public class EmpoyeeDataUtil {

	private List<Employee> employees;
	
	public EmpoyeeDataUtil()
	{
		loadSampleData();
		
	}
	
	public void loadSampleData()
	{
		employees = new ArrayList<>();
		
		employees.add(new Employee("Eric","Carandang","eric.carandang@outlook.com","Emerson","09957361999","Manager"));
		employees.add(new Employee("Nicole","Santos","nicole.santos@outlook.com","Emerson","09177113830","Surpervisor"));
		employees.add(new Employee("Michael", "Crystal", "Michael.Crystal@outlook.com","Emerson","09957568109","Employee"));
	}
	public List<Employee> getEmployees()
	{
		return employees;
	}
}
