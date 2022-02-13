package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.model.Employee;
import com.nagarro.service.EmpMangService;
import com.nagarro.service.SignService;

@Controller
public class SignController {
	
	@Autowired
	SignService signservice;
	@Autowired
	private EmpMangService empMangService;
	
	@RequestMapping("/SignIn")
	public ModelAndView signIn(@RequestParam("hrmId") String hrmId,
			@RequestParam("hrmPswd") String hrmPswd) {

		ModelAndView mv = new ModelAndView();

		if (signservice.validateHRManager(hrmId, hrmPswd)) {
			mv.addObject("hrmId", hrmId);
			System.out.println("hi");
            List<Employee> employees = empMangService.getEmployee();
			mv.addObject("employees", employees);
			System.out.println(employees);
			mv.setViewName("home");
		} else {
			mv.setViewName("index");
		}

		return mv;
	}
	@RequestMapping("/SignOut")
	public ModelAndView signOut() {

		ModelAndView mv = new ModelAndView();
		mv.addObject("hrmId", null);
		mv.setViewName("index");
		return mv;
	}

}
