<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




<h3>Add a New product:</h3>


<%
	Object strMessage = request.getAttribute("message");
	
	if( strMessage != null)  { %>
	
	<h3><% out.println(strMessage.toString()); %></h3>
	<% }%>
	
	
	
	
	<div style="width: 40%; height: 100%; margin: 20px;">
		<form class="form-inline" action="saveProduct">
		
		<div class="form-group mx-sm-3 mb-2">
				<label class="sr-only">Product ID</label>
				<input type="number" id="replyNumber" name="sid" min="0"
					data-bind="value:replyNumber" />
			</div>

			<div class="form-group mx-sm-3 mb-2">
				<label class="sr-only">Product Name</label> <input type="text"
					class="form-control" name="sname" placeholder="Product name">
			</div>
			
			<div class="form-group mx-sm-3 mb-2">
				<label class="sr-only">Product Company</label> <input type="text"
					class="form-control" name="scompany" placeholder="Product company">
			</div>
			<button type="submit" class="btn btn-primary mb-2">submit</button>
		</form>

	</div>
	
	
	
	
	

</body>
</html>