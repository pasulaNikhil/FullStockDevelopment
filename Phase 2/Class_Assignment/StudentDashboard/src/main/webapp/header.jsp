<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.io.*,java.util.*, jakarta.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ABC University</title>
</head>
<body>
<h1> ABC University</h1>
	<%
	Date date = new Date();
	out.print( "<h2>"+"Today's date: " +date.toString()+"</h2>");
	%>
	Fill the below details of the forms

</body>
</html>