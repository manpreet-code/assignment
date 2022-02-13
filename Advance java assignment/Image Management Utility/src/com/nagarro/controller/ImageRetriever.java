package com.nagarro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.Models.Image;
import com.nagarro.services.ImageManagementService;

@WebServlet("/ImageRetriever")
public class ImageRetriever extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("user") == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			ImageManagementService imageManagement = new ImageManagementService();
			String imageId = request.getParameter("imageId");
			Image image = imageManagement.getImage(imageId);
			if (image != null) {
				response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
				try {
					response.getOutputStream().flush();
					response.getOutputStream().write(image.getPhoto());
					response.getOutputStream().close();
				} catch (IOException e) {
//					e.printStackTrace();
				}
			}
		}

	}
}
