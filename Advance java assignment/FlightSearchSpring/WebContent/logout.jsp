<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
	<%
		request.getSession().removeAttribute("authorized");
	%>
	<p align="center">
	<font size="8">You Have Logged Out Successfully</font>
	</p>
	<p align="center">
		<h8> <a href="index.jsp"> Click here to re-Login. </a></h8>
	</p>

</body>
</html>