package com.nagarro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.nagarro.model.Employee;
import com.nagarro.service.EmpMangService;

@Controller
public class EmpMangController {

	

	@Autowired
	private EmpMangService empMangService;

	@RequestMapping("Upload")
	public ModelAndView uploadEmployee(@RequestParam("empName") String empName, @RequestParam("empLoc") String empLoc,
			@RequestParam("empMail") String empMail, @RequestParam("empDOB") String empDOB,
			@RequestParam("hrmId") String hrmId) {
		

		ModelAndView mv = new ModelAndView();
		System.out.println(empName+empLoc+empMail);

		
		Employee emp = new Employee();
		emp.setEmployeeName(empName);
		emp.setLocation(empLoc);
		emp.setEmail(empMail);
		emp.setDateOfBrith(empDOB);


		empMangService.addEmployee(emp);

		List<Employee> employees = empMangService.getEmployee();
		mv.addObject("employees", employees);

		mv.addObject("hrmId", hrmId);
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("Update")
	public ModelAndView updateEmployee(@RequestParam("empCode") long empCode, @RequestParam("empName") String empName,
			@RequestParam("empLoc") String empLoc, @RequestParam("empMail") String empMail,
			@RequestParam("empDOB") String empDOB, @RequestParam("hrmId") String hrmId) {

		ModelAndView mv = new ModelAndView();
	

		Employee emp = new Employee();
		emp.setEmployeeCode(empCode);
		emp.setEmployeeName(empName);
		emp.setLocation(empLoc);
		emp.setEmail(empMail);
		emp.setDateOfBrith(empDOB);

		empMangService.updateEmployee(emp);

		List<Employee> employees = empMangService.getEmployee();
		mv.addObject("employees", employees);

		mv.addObject("hrmId", hrmId);
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("DeleteEmployee")
	public ModelAndView deleteEmployee(@RequestParam("empCode") long empCode, @RequestParam("hrmId") String hrmId) {

		ModelAndView mv = new ModelAndView();

		empMangService.deleteEmployee(empCode);

		List<Employee> employees = empMangService.getEmployee();
		mv.addObject("employees", employees);

		mv.addObject("hrmId", hrmId);
		mv.setViewName("home");

		return mv;
	}

	@RequestMapping("EditEmployee")
	public ModelAndView EditEmployee(@RequestParam("empCode") long empCode, @RequestParam("hrmId") String hrmId) {

		ModelAndView mv = new ModelAndView();
		

		Employee emp = empMangService.getEmployee(empCode);
		

		mv.addObject("employee", emp);

		mv.addObject("hrmId", hrmId);
		mv.setViewName("edit");

		return mv;
	}

	@RequestMapping("Download")
	public void downloadEmployeeList(HttpServletRequest request, HttpServletResponse response) {

		List<Employee> employees = empMangService.getEmployee();

		String csvFileName = "employees.csv";
		response.setContentType("text/csv");
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", csvFileName);
		response.setHeader(headerKey, headerValue);
		ICsvBeanWriter csvWriter;

		try {
			csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

			String[] headers = new String[] { "EmployeeCode", "EmployeeName", "Location", "Email", "DateOfBrith" };

			csvWriter.writeHeader(headers);
			for (Employee employee : employees) {
				csvWriter.write(employee, headers);
			}
			csvWriter.close();
		} catch (IOException ioexception) {
			System.out.println(ioexception.getMessage());
			
		} 

	}
}

