<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.nagarro.model.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>
</head>
<body>
	<c:if test="${hrmId != null}">
		<header>
			<div>
				<table width="100%">
					<tr>
						<td>
							<h2>
								Welcome
								<c:out value="${hrmId}" />
								! You can manage employees here.
							</h2>
						</td>
						<td align="right">
							<form action="SignOut">
								<input type="submit" value="SignOut" />
							</form>
						</td>
					</tr>
				</table>
			</div>
		</header>
		<fieldset>
			<legend>
				<h3>&nbsp Employee Listings &nbsp</h3>
			</legend>
			<div>
				<div align="center">

					<div align=center>
						<a href="upload.jsp?hrmId=${hrmId}"> <input type="submit"
							value="Upload Employee Details" />
						</a>
					</div>

					<br>

					<div align="center">
						<form action="Download">
							<input type="hidden" name="hrmId" value="${hrmId}"> <input
								type="submit" value="Download Employee Details" />
						</form>
					</div>
				</div>



				<br>

				<table class="result">
					<tr>
						<th>Employee Code</th>
						<th>Employee Name</th>
						<th>Employee Location</th>
						<th>Employee E-mail</th>
						<th>Employee D.O.B</th>
						<th colspan="2">Actions</th>
					</tr>
					<c:forEach items="${employees}" var="employee">

						<tr class="emp_row">
							<td>${employee.getEmployeeCode()}</td>
							<td>${employee.getEmployeeName()}</td>
							<td>${employee.getLocation()}</td>
							<td>${employee.getEmail()}</td>
							<td>${employee.getDateOfBrith()}</td>
							<td>
								<form action="EditEmployee" method="get">
									<input type="hidden" name="empCode"
										value="${employee.getEmployeeCode()}"> <input
										type="hidden" name="hrmId" value="${hrmId}"> <input
										type="submit" value="Edit">
								</form>

							</td>
							<td><form action="DeleteEmployee" align="center">
									<input type="hidden" name="empCode"
										value="${employee.getEmployeeCode()}"> <input
										type="hidden" name="hrmId" value="${hrmId}"> <input
										type="submit" value="Delete">
								</form></td>
						</tr>


					</c:forEach>
				</table>

			</div>

			<br> <br>

		</fieldset>
	</c:if>
	

</body>
</html>