package com.nagarro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.finalvalues.FinalValues;


@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession() == null) {
			response.sendRedirect("index.jsp");
		}
		request.getSession().removeAttribute(FinalValues.USER);
		request.getSession().removeAttribute(FinalValues.AUTHORIZED);
		request.getSession().invalidate();
		request.getRequestDispatcher("logout.jsp").forward(request, response);
	}
}
