package com.nagarro.assignment.RestAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.assignment.RestAPI.model.Employee;
import com.nagarro.assignment.RestAPI.dao.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao EmployeeDao;

	@Override
	public List<Employee> getEmployee() {
		
		return EmployeeDao.findAll();
	}

	@Override
	public Employee getEmployee(long EmployeeCode) {
		return EmployeeDao.getOne(EmployeeCode);
	}

	@Override
	public Employee addEmployee(Employee Employee) {
		EmployeeDao.save(Employee);
		return Employee;
	}

	@Override
	public Employee updateEmployee(Employee Employee) {
		EmployeeDao.save(Employee);
		return Employee;
	}

	@Override
	public void deleteEmployee(long EmployeeCode) {
		Employee entity = EmployeeDao.getOne(EmployeeCode);
		EmployeeDao.delete(entity);

	}

}
