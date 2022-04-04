<%@page import="com.file.web.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>


<body bgcolor="green">
	<h1>The Prouduct</h1>
	
	
	<%
	Object strMessage = request.getAttribute("message");
	
	if( strMessage != null)  { %>
	
	<h3><% out.println(strMessage.toString()); %></h3>
	<% }%>
	

	<%
	Product p1 = (Product) request.getAttribute("product");
	
	if( p1.getName() != null && p1.getId() >= 0 )  { %>
         <div style="width: 40%; height: 100%;">
		<table class="table table-striped table-dark">
			<thead>
				<tr>
					<th scope="col">Product ID</th>
					<th scope="col">Product Name</th>
					<th scope="col">Product Company</th>

				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">
						<%
						out.print(p1.getId());
						%>
					</th>
					<td>
						<%
						out.print(p1.getName());
						%>
					</td>
					<td>
						<%
						out.print(p1.getCompany());
						%>
					</td>

				</tr>
				<tr>
			</tbody>
		</table>

	</div>
      <% } else { %>
      
      <div class="p-3 mb-2 bg-info text-white" style=" width: 1000px; height: 200px;" >Sorry no product in this ID !</div>
        
      <% } %>
   </body>
</html>
	

	

</body>
</html>