<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" />
<form action="Dashboard.jsp" method="post">
	<table>
		<tr>
		<td>UserName</td>
		<td><input type="text" name="uname" value="" /></td>
		</tr>
		<tr>
		<td>PassWord</td>
		<td><input type="password" name="pass" value="" /></td>
		</tr>
	</table>
	<input type="submit" value="Login">
</form>


</body>
</html>