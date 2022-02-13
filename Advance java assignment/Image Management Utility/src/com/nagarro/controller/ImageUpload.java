package com.nagarro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.*;

import com.nagarro.Models.*;
import com.nagarro.services.*;


@WebServlet("/ImageUpload")
public class ImageUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private User getUser(HttpServletRequest request) {
		LoginService login = new LoginService();
		return login.getUserDetails(((User) request.getSession().getAttribute("user")).getUsername());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("user") == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			String imageName = null;
			byte bytes[] = null;
			double imageSize = 0;

			if (ServletFileUpload.isMultipartContent(request)) {
				List<FileItem> fileItems = new ServletFileUpload(new DiskFileItemFactory())
						.parseRequest(new ServletRequestContext(request));

				for (FileItem item : fileItems) {
					if (item.isFormField()) {
						imageName = item.getString();
					} else {
						imageSize = item.getSize() / 1024.0;
						bytes = item.get();
					}
				}

				User user = (User) request.getSession().getAttribute("user");
				Image image = new Image(imageName, imageSize, bytes);
				image.setUser(user);

				if (user != null) {
					if (image.getImageSize() < 1024) {
						if (GetImageSize.getImagesSize(user.getUsername()) + image.getImageSize() < 10240) {
							ImageManagementService imageManagement = new ImageManagementService();
							imageManagement.addImage(image);
							request.getSession().setAttribute("user", getUser(request));
							request.setAttribute("message", "File Uploaded Successfully");
							request.getRequestDispatcher("home.jsp").forward(request, response);

						} else {
							request.setAttribute("message", "Total images size exceeded > 10 MB");
							request.getRequestDispatcher("home.jsp").forward(request, response);
						}
					} else {
						request.setAttribute("message", "Image size exceeded 1MB.");
						request.getRequestDispatcher("home.jsp").forward(request, response);
					}
				}

			} else {
				request.setAttribute("message", "Sorry image could not be uploaded");
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
		}
	}

}
