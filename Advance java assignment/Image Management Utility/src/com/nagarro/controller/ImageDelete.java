package com.nagarro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.Models.User;
import com.nagarro.services.ImageManagementService;
import com.nagarro.services.LoginService;


@WebServlet("/ImageDelete")
public class ImageDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("index.jsp");
		} else {
			LoginService login = new LoginService();
			ImageManagementService imageManagement = new ImageManagementService();
			String imageid = request.getParameter("imageid");
			imageManagement.deleteImage(imageid);
			User userUpdated = login.getUserDetails(((User) request.getSession().getAttribute("user")).getUsername());
			request.getSession().setAttribute("user", userUpdated);
			response.sendRedirect("home.jsp");
		}
	}

}
