package com.nagarro.controller;

import com.nagarro.Models.User;
import com.nagarro.finalvalues.FinalValues;
import com.nagarro.services.LoginService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginService login = new LoginService();
		String username = request.getParameter(FinalValues.USERNAME);
		String password = request.getParameter(FinalValues.PASSWORD);
		if (login.userAuthentication(username, password)) {
			User user = login.getUserDetails(username);
			request.getSession().setAttribute(FinalValues.AUTHORIZED, "true");
			request.getSession().setAttribute(FinalValues.USER, user);
			request.getRequestDispatcher("home.jsp").forward(request, response);

		} else {
			request.getSession().setAttribute(FinalValues.AUTHORIZED, "false");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
