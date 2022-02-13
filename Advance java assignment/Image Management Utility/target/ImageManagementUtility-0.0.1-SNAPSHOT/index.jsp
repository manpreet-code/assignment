<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>


<body>
	<div class="container">
		<h3 style="background-color: #b8f0fb;">Login</h3>
		<form action="Login" method="post">
			<div class="form-group">
				<label for="username">Username:</label> <input type="text"
					class="form-control" id="username" placeholder="Enter username"
					name="username">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="password" placeholder="Enter password"
					name="password">
			</div>
			<button style="float: right" type="submit" class="btn btn-success">Submit</button>

			<%
				if (session.getAttribute("authorized") != null && session.getAttribute("authorized").equals("false")) {
			%>
			<p
				style="color: crimson; text-align: center; font-weight: bold; font-family: Arial, Helvetica, sans-serif;">Invalid
				credentials</p>
			<%
				session.setAttribute("authorized", null);
				}
			%>
		</form>


		<button type="button" class="btn btn-link" data-toggle="modal"
			data-target="#myModal">Reset Password</button>

		<!-- Modal -->
		<div id="myModal" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Reset Password</h4>
					</div>
					<center>
						<div class="modal-body">
							<div class="modal-body">
								<form action="ResetPassword" method="post">
									<input type="text" name="username"
										placeholder="Confirm Username" required> <br /> <input
										type="text" name="fullname" placeholder="Confirm Full Name"
										required> <br /> <input type="password"
										name="passwordnew" id="passwordnew" placeholder="New Password"
										required> <br /> <input type="password"
										name="passwordnewconfirm" id="passwordnewconfirm"
										placeholder="Confirm new password" required> <br /> <input
										type="submit" value="Change Password">

								</form>
							</div>
						</div>
					</center>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
	</div>

	<%
		if (session.getAttribute("passwordmessage") != null) {
	%><p
		style="color: blue; text-align: center; font-weight: bold; font-family: Arial, Helvetica, sans-serif;">
		<%=session.getAttribute("passwordmessage")%></p>
	<%
		session.setAttribute("passwordmessage", null);
		}
	%>

</body>
</html>