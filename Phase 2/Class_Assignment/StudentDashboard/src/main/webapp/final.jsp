<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*, jakarta.servlet.*"%>
<%
String uname = (String)request.getSession().getAttribute("uname");
String marks10 = request.getParameter("marks10");
String marks12 = request.getParameter("marks12");
String mathm = request.getParameter("mathm");
String chemm = request.getParameter("chemm");
String phym = request.getParameter("phym");
session.putValue("marks10",marks10);
session.putValue("marks12",marks12);
session.putValue("mathm",mathm);
session.putValue("chemm",chemm);
session.putValue("phym",phym);
int mathmint=Integer.parseInt(mathm);
int chemmint=Integer.parseInt(chemm);
int phymint=Integer.parseInt(phym);
int totalmarksint=mathmint+chemmint+phymint;
//String totalPCM=String.valueOf(totalmarksint);  
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Final Record Page</h1>
<%out.println("<h2>Hello " + uname + "</h2>"); %>
Verify your details:

	<table>
	<tr>
	<td>Total Marks in 10th:</td>
	<td><%out.println(marks10); %><td>
	</tr>
	<tr>
	<td>Total Marks in 12th:</td>
	<td><%out.println(marks12); %><td>
	</tr>
	<tr>
	<td>Total Marks in PCM /300:</td>
	<td><%out.println(totalmarksint); %><td>
	</tr>
	</table>


</body>
</html>