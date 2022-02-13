<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<style>
input[type=text], select {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
input[type=password], select {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
input[type=submit] {
  width: 50%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<body>
<p align="right"><a href="index.jsp">Back</a></p>
	<form action="SignUp" method="post" 
		align="middle">
		<header>
			<h1>Sign Up</h1>
		</header>
		UserName :<br />
		<input type="text" name="username" placeholder="Username" size="50"
			required>
		<br />
		<br />
		Phone No. :<br />
		<input type="text" name="phone" placeholder="Phone no." size="50"
			required> 
		<br />
		<br />
		Password :<br />
		<input type="password" name="password" id="password"
			placeholder="password"  size="50" required><br>
		<br />
		<br /><input type="submit" value="Sign Up">
	</form>



</body>
</html>