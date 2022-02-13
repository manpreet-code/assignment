<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.nagarro.Models.User"%>
<%@page import="com.nagarro.Models.Image"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>

<body>
	<%
	if (session.getAttribute("user") == null) {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	User user = (User) session.getAttribute("user");
	%>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Image Management Utility</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="Logout" class="glyphicon glyphicon-log-in">
						Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<p style="margin-left: 16px;">Please select an image file to
			upload(Max Size 1 MB)</p>
		<form action="ImageUpload" method="post" enctype="multipart/form-data">
			<div class="col-md-2">
				<input type="text" name="imagename" placeholder="Name of image"
					required />
			</div>
			<div class="offset-1 col-md-3">
				<input type="file" name="image" accept="image/*" required />
			</div>
			<div class="col-md-4  d-none d-md-block"></div>
			<div class="col-md-2">
				<input type="submit" value="Submit"> <input type="reset"
					value="Cancel" />
			</div>
	</div>
	<%
	String message = (String) request.getAttribute("message");
	%>
	<%
	if (message != null) {
	%>
	<%=message%>
	<%
	}
	%>
	</form>
	</div>
	<hr />
	<div class="container">
		<div class="row">


			<div class="col-md-12">
				<h3>Uploaded Images</h3>
				<div class="table-responsive">

					<%
					String editImageMessage = (String) request.getAttribute("editImageMessage");
					%>
					<%
					if (editImageMessage != null) {
					%>
					<%=editImageMessage%>
					<%
					}
					%>
					<table id="mytable" border="1"
						class="table table-bordred table-striped">

						<thead>

							<th>S.No</th>
							<th>Name</th>
							<th>Size</th>
							<th>Preview</th>
							<th colspan="2">Actions</th>
						</thead>

						<tbody>
							<%
							Double totalSize = 0.0d;
							Set<Image> images = user.getImages();
							int i = 0;
							if (!images.isEmpty()) {
								for (Image image : images) {
									i++;
							%>
							<!-- This will be in a for loop for all the images there are  -->
							<tr>
								<%
								totalSize += image.getImageSize();
								%>
								<td><%=i%></td>
								<td><%=image.getImageName()%></td>
								<td><%=image.getImageSize()%></td>
								<td><img
									src="ImageRetriever?imageId=<%=image.getImageId()%>"
									height="99" width="99"></img></td>


								<!-- Modal starts here -->
								<td>
									<button type="button"
										class="glyphicon glyphicon-edit btn btn-primary a-btn-slide-text"
										data-toggle="modal" data-target="#editModal">Edit</button> <!-- Modal -->
									<div class="modal fade" id="editModal" role="dialog">
										<div class="modal-dialog">

											<!-- Modal content-->
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal">&times;</button>
													<h4 class="modal-title">Edit Image</h4>
												</div>
												<div class="modal-body">
													<form action="ImageEdit?imageId=<%=image.getImageId()%>"
														method="post" enctype="multipart/form-data">
														<input type="text" name="imagenamenew"
															placeholder="Name of image"
															value=<%=image.getImageName()%> required> <br />
														<input type="file" name="imagenew" accept="image/*"
															required> <br /> <input type="submit"
															value="Update">
														<hr />
													</form>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default"
														data-dismiss="modal">Close</button>
												</div>
											</div>

										</div>
									</div>
								<td><a href="ImageDelete?imageid=<%=image.getImageId()%>"
									class="btn btn-primary a-btn-slide-text"> <span
										class="glyphicon glyphicon-remove" aria-hidden="true"></span>
										<span><strong>Delete</strong></span>
								</a>
							</tr>
							<%
							}
							}
							%>
							<tr>
								<td></td>
								<td></td>
								<td><%=totalSize%></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>