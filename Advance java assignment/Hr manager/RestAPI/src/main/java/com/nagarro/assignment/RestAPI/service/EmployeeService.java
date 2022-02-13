package com.nagarro.assignment.RestAPI.service;

import java.util.List;

import com.nagarro.assignment.RestAPI.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployee();
	
	public Employee getEmployee(long EmployeeCode);
	
	public Employee addEmployee(Employee Employee);
	
	public Employee updateEmployee(Employee Employee);
	
	public void deleteEmployee(long EmployeeCode);
	
	
	
	

}
