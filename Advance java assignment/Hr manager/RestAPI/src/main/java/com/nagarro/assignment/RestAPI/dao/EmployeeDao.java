package com.nagarro.assignment.RestAPI.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.assignment.RestAPI.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {


}
