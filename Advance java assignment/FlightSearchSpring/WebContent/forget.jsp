<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Password</title>
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
	<form action="ForgotPassword" method="post" 
		align="middle">
		<header>
			<h1>Forgot Password</h1>
		</header>
		UserName :<br /> <input type="text" name="username"
			placeholder="Confirm Username"  required> <br /> <br />
		Phone No. :<br /><input type="text" name="phone"
			placeholder="Confirm Phone no." required> <br /> <br /> 
		New Password :<br /> <input type="password" name="passwordnew"
			id="passwordnew" placeholder="New Password" 
			required> <br /><br />
		 Confirm Password :<br /> <input type="password"
			name="passwordnewconfirm" id="passwordnewconfirm"
			placeholder="Confirm new password"  required>
		<br />  <br /><input type="submit" value="Change Password">
	</form>


</body>
</html>