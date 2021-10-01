package com.benilde.lecture;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Employee {

	private String firstName;
	private String lastName;
	private String email;
	private String company;
	private String mobileNo;
	private String position;
	
	public Employee(String firstName, String lastName, String email,String company, String mobileNo, String position)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.company = company;
		this.mobileNo = mobileNo;
		this.position = position;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
}
