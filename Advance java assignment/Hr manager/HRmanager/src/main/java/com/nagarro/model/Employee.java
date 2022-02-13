package com.nagarro.model;



public class Employee {
	
	private long EmployeeCode;
	

	private String EmployeeName;
	
	
	private String Location;
	

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
