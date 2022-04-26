<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
	<h2 style="text-align: center">Login Page</h2>

	<div style="color: red;">${error}</div>


	<form style="text-align: center" action="loginform" method='post'>

		<label for="username">Name:</label><br> <input type="text"
			id="username" placeholder="Name Required" name="username" required><br>
		<br> <label for="password">Password:</label><br> <input
			type="text" id="password" placeholder="Password Required"
			name="password" required><br> <br> <input
			type="submit" value="Submit">
	</form>
</body>
</html>