package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.AirportCodeLoaderService;
import services.LoginService;

/**
 * Controller for login and purposes
 * 
 */
@Controller
public class Login {

	@Autowired
	private LoginService LoginService;

	@Autowired
	private AirportCodeLoaderService airportCodeLoader;

	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public ModelAndView Loginuser(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		List<String> fromAirportCodes = airportCodeLoader.getFromAirportCodes();
		List<String> toAirportCodes = airportCodeLoader.getToAirportCodes();
		if (LoginService.loginAuthentication(username, password)) {
			mv.addObject("fromAirportCodes", fromAirportCodes);
			mv.addObject("toAirportCodes", toAirportCodes);
			mv.addObject("authorized", new String("true"));
			mv.setViewName("homepage");
		} else {
			mv.setViewName("index");
		}
		return mv;
	}

	@RequestMapping(value = "/SignUp", method = RequestMethod.POST)
	public ModelAndView signIn(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String username = request.getParameter("username");
		int phone = Integer.parseInt(request.getParameter("phone"));
		String password = request.getParameter("password");
		if (!LoginService.loginAuthentication(username, password)) {
			LoginService.signUp(username, password, phone);
			mv.setViewName("index");
		}
		return mv;
	}

	@RequestMapping(value = "/ForgotPassword", method = RequestMethod.POST)
	public ModelAndView forgetPassword(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();
		String username = request.getParameter("username");
		int phone = Integer.parseInt(request.getParameter("phone"));
		String password = request.getParameter("passwordnew");
		String passwordConfirm = request.getParameter("passwordnewconfirm");
		if (password.equals(passwordConfirm)) {
			LoginService.forgetPassword(username, password, phone);
			mv.setViewName("index");
		}

		return mv;
	}

}
