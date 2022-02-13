package com.nagarro.assignment.RestAPI.controller;

import com.nagarro.assignment.RestAPI.model.Employee;
import com.nagarro.assignment.RestAPI.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService EmployeeService;

	@GetMapping("/Employee")
	public List<Employee> getEmployee() {
		return this.EmployeeService.getEmployee();
	}

	@GetMapping("/Employee/{EmployeeCode}")
	public Employee getEmployee(@PathVariable String EmployeeCode) {
		return this.EmployeeService.getEmployee(Long.parseLong(EmployeeCode));
	}

	@PostMapping("/Employee")
	public void addEmployee(@RequestBody Employee Employee) {
		 this.EmployeeService.addEmployee(Employee);
	}

	@PutMapping("/Employee")
	public void updateEmployee(@RequestBody Employee Employee) {
		 this.EmployeeService.updateEmployee(Employee);
	}

	@DeleteMapping("/Employee/{EmployeeCode}")
	public void deleteEmployee(@PathVariable String EmployeeCode) {
		this.EmployeeService.deleteEmployee(Long.parseLong(EmployeeCode));
	}
}
