<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="dto.FlightStructure"%>

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

<
style type ="text /css">.result {
	width: 100%;
	border-collapse: collapse;
	background-color: #f2f2f2;
}

.result td {
	text-align: center;
	height: 25px;
	border: 1px solid black;
}

th {
	text-align: center;
	height: 50px;
	border: 1px solid black;
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
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
<meta charset="ISO-8859-1">
<title>result</title>
</head>
<body>

	<c:if test="${searchResult.size() != 0}">
		<header>
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="homepage.jsp">Search for Flights</a>
					</div>
					<ul class="nav navbar-nav navbar-right">
						<%
							if (session.getAttribute("username") == null && (session.getAttribute("authorized") == "false")) {
									response.sendRedirect("index.jsp");
								}
						%>
						<li><a href="logout.jsp">Logout</a></li>
					</ul>
				</div>
			</nav>
		</header>
		<table style="width: 100%">
			<tr>
				<th>FLIGHT NUMBER</th>
				<th>DEPARTURE LOCATION</th>
				<th>ARRIVAL LOCATION</th>
				<th>DATE OF FLIGHT</th>
				<th>FLIGHT TIME</th>
				<th>FLIGHT DURATION</th>
				<th>FARE</th>
				<th>SEAT AVAILABILITY</th>
				<th>CLASS</th>
			</tr>
			<c:forEach items="${searchResult}" var="flight">
				<tr>
					<td><c:out value="${flight.getFlightNumber()}" /></td>
					<td><c:out value="${flight.getDepartLocation()}" /></td>
					<td><c:out value="${flight.getArrivalLocation()}" /></td>
					<td><c:out value="${flight.getFlightDate()}" /></td>
					<td><c:out value="${flight.getFlightTime()}" /></td>
					
					<td><c:out value="${flight.getFlightDuration()}" /></td>
					<td><c:out value="${flight.getFare()}" /></td>
					<td><c:out value="${flight.getSeatAvailablility()}" /></td>
					<td><c:out value="${flight.getFlightClass()}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${searchResult.size() == 0}">
		<header>
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="homepage.jsp">Flights Not Found</a>
					</div>
					<ul class="nav navbar-nav navbar-right">
						<%
							if (session.getAttribute("username") == null && (session.getAttribute("authorized") == "false")) {
									response.sendRedirect("index.jsp");
								}
						%>
						<li><a href="logout.jsp">Logout</a></li>
					</ul>
				</div>
			</nav>
		</header>
	</c:if>
	<br>
</body>
</html>