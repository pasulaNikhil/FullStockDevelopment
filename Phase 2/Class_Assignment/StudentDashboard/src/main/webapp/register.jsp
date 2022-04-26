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
<form action="verify.jsp" method="post">
	<table>
		<tr>
		<td>UserName</td>
		<td><input type="text" name="uname" value="<%= session.getAttribute("uname") %>" /></td>
		</tr>
		<tr>
		<td>PassWord</td>
		<td><input type="password" name="pass" value="" /></td>
		</tr>
		<tr>
		<td>Age</td>
		<td><input type="text" name="age" value="" /></td>
		</tr>
		<tr>
		<td>Branch</td>
		<td><input type="text" name="branch" value="" /></td>
		</tr>
		<tr>
		<td>AadharCard No.</td>
		<td><input type="text" name="adhno" value="" /></td>
		</tr>
	</table>
	<input type="submit" value="Register">
</form>

</body>
</html>