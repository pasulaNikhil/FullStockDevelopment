<html>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>

	<h3>Search for a product by ID :::</h3>
	<div style="width: 40%; height: 30%; margin: 20px;">
		<form class="form-inline" action="getProduct">

			<div class="form-group mx-sm-3 mb-2">
				<label class="sr-only">Password</label>
				<!-- <input type="text" name="pid" class="form-control" placeholder="ID number"> -->
				<input type="number" id="replyNumber" name="pid" min="0"
					data-bind="value:replyNumber"  Placeholder="Product ID" />
			</div>
			<button type="submit" class="btn btn-primary mb-2">Find</button>
		</form>

	</div>
	
	<!-- Show the user if the product saved successfully or not -->
	<%
	Object strMessage = request.getAttribute("message");
	
	if( strMessage != null)  { %>
	
	<h3><% out.println(strMessage.toString()); %></h3>
	<% }%>
	
	
	<!-- Alert the client that the id should be number not text -->
	<%
	Object idmessage = request.getAttribute("idMessage");
	
	if( idmessage != null)  { %>
	
	<h3><% out.println(idmessage.toString()); %></h3>
	<% }%>
	

	<h3>Add a New product:</h3>
	<div style="width: 40%; height: 50%; margin: 30px;">
		<form class="form-inline" action="saveProduct">

			<div class="form-group mx-sm-3 mb-2">
				<label class="sr-only">Product ID</label> <input type="number"
					id="replyNumber" name="sid" min="0" data-bind="value:replyNumber" placeholder="Product ID" />
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


<!-- <input type="number" id="replyNumber" name="pid" min="0"
	data-bind="value:replyNumber" />
 -->