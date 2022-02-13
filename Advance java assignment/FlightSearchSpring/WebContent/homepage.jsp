<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="services.AirportCodeLoaderService"%>
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
<style type="text/css">
.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

input[type=submit] {
	background-color: #1E90FF;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #4169E1;
}

input[type=date], select {
	width: 100%;
	padding: 12px; 
	border: 1px solid #ccc; 
	border-radius: 4px; 
	margin-top: 3px;
	margin-bottom: 3px;
}
</style>
</head>
<body>
	<% if (session.getAttribute("authorized") != "false") { %>
		<header>
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="homepage.jsp">Search for Flights</a>
					</div>
					<ul class="nav navbar-nav navbar-right">
						<%
							if (session.getAttribute("authorized") == "false") {
									response.sendRedirect("index.jsp");
								}
						%>
						<li><a href="logout.jsp">Logout</a></li>
					</ul>
				</div>
			</nav>
		</header>

		<div align="center" class="container">
			<form action="search" method="get">
				<table class="w3-table w3-striped w3-border">
					<tr>
						<td>From :</td>
						<td><select name="from">
								<c:forEach items="${fromAirportCodes}" var="fromAirportCode">
									<option value="${fromAirportCode}">${fromAirportCode}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>To :</td>
						<td><select name="to">
								<c:forEach items="${toAirportCodes}" var="toAirportCode">
									<option value="${toAirportCode}">${toAirportCode}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>Date :</td>
						<td><input type="date" name="date" /></td>
					</tr>
					<tr>
						<td>Class :</td>
						<td><select name="class">
								<option value="E">Economy</option>
								<option value="B">Business</option>
						</select></td>
					</tr>
					<tr>
						<td>Sort by :</td>
						<td><select name="sortBy">
								<option value="1">Fare</option>
								<option value="2">Fare and Flight Duration</option>
						</select></td>
					</tr>
					<tr>
						<td></td>
						<td align="right"><input type="submit" value="Search" /></td>
					</tr>
				</table>
			</form>
		</div>
	<%} %>

</body>
</html>