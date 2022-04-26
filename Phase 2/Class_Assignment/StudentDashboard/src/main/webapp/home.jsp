<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.io.*,java.util.*, jakarta.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Page</title>
</head>
<body>
<h1>Welcome to student page</h1>
<%
	Date date = new Date();
	out.print( "<h2>"+"Today's date: " +date.toString()+"</h2>");
	%>
	<form action="login.jsp" method="GET">
	<input type="submit" name="Login" value="Login">
	</form>
	<form action="register.jsp" method="GET">
	<input type="submit" name="Register" value="Register">
	</form>
</body>
</html>