package com.nagarro.assignment.RestAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long EmployeeCode;
	
	@Column(name = "employee_name", nullable = false, length = 500)
	private String EmployeeName;
	
	@Column(name = "location")
	private String Location;
	
	@Column(name = "email", length = 100)
	private String Email;

	private String DateOfBrith;

	public long getEmployeeCode() {
		return EmployeeCode;
	}

	public void setEmployeeCode(long employeeCode) {
		EmployeeCode = employeeCode;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getDateOfBrith() {
		return DateOfBrith;
	}

	public void setDateOfBrith(String dateOfBrith) {
		DateOfBrith = dateOfBrith;
	}

}
