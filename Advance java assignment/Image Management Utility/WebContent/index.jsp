<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>

<body>
	<div style="text-align: center; border:1px solid black; padding:10px;">
		<h1>Login</h1>
		<form action="Login" method="post">
			<p>
				<label for="username">Username :</label> <input type="text"
					placeholder="Enter username" name="username">
			</p>

			<p>
				<label for="password">Password : </label> <input type="password"
					id="password" placeholder="Enter password" name="password"
					length=50>
			</p>
			<button type="submit">Submit</button>

			<%
				if (session.getAttribute("authorized") != null && session.getAttribute("authorized").equals("false")) {
			%>
			<p style="color: red; font-family: Arial;">Invalid user details!</p>
			<%
				session.setAttribute("authorized", null);
				}
			%>
		</form>

	</div>
</body>
</html>