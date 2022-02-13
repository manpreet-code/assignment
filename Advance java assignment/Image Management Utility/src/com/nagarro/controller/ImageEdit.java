package com.nagarro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.nagarro.Models.*;
import com.nagarro.services.*;


@WebServlet("/ImageEdit")
public class ImageEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private User getUser(HttpServletRequest request) {
		LoginService login = new LoginService();
		return login.getUserDetails(((User) request.getSession().getAttribute("user")).getUsername());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (request.getSession().getAttribute("user") == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			if (!ServletFileUpload.isMultipartContent(request)) {
				return;
			}
			String imageId = request.getParameter("imageId");
			ImageManagementService imageManagement = new ImageManagementService();
			Image img = imageManagement.getImage(imageId);
			float currentImageSize = (float) img.getImageSize();
			double imageSize = 0;
			byte[] bytes = null;
			String imageName = null;

			response.setContentType("text/html;charset=UTF-8");

			ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());

			List<FileItem> items = null;
			try {
				items = servletFileUpload.parseRequest(request);
			} catch (Exception e) {
				e.printStackTrace();
			}


			for (FileItem file : items) {
				if (file.isFormField()) {
					imageName = file.getString();
					if (!imageName.isEmpty()) {
						img.setImageName(imageName);
					}
				} else {
					imageSize = file.getSize() / 1024.0;
					if (imageSize != 0) {
						bytes = file.get();
						img.setImageSize(imageSize);
						img.setPhoto(bytes);
					}
				}
			}

			if (img.getImageSize() > 1024 || (GetImageSize.getImagesSize(user.getUsername()) + imageSize - currentImageSize) > 10240) {
				request.setAttribute("editImageMessage","Image cannot be greater than 1MB and total allowed limit is 10MB.");
				request.getRequestDispatcher("home.jsp").forward(request, response);

			} else {
				imageManagement.editImage(img);
			}
			request.getSession().setAttribute("user", getUser(request));
			response.sendRedirect("home.jsp");
		}
	}

}
