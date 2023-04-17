<%
	String name=(String)session.getAttribute("name");
	if(name==null){
		session.setAttribute("msg", "Please Login First!");
		response.sendRedirect("Login.jsp");
	}else{
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ProductApp</title>
</head>
<body>
	<%
		String msg=(String)session.getAttribute("msg");
		if(msg!=null){
	%>
			<p style="background-color:yellow;"> <%=msg %> </p>
	<%		
			session.setAttribute("msg", null);
		}
	%>
	
	<h1>ProductApp</h1>
	<hr>
	<p>
		<a href="AdminHome.jsp">Home</a> &nbsp;&nbsp;&nbsp;&nbsp;
		Welcome: <b><%= name %></b> &nbsp;&nbsp;&nbsp;&nbsp;
		<a href="Logout">Logout</a>
	</p>
	<hr>
	<h3>Add New Product</h3>
	<form action='AddProduct' method='post'>
		<label>Company Name:</label>
		<input type='text' name='companyname' required /> <br/><br/>
		<label>Name:</label>
		<input type='text' name='name' required /> <br/><br/>
		<label>Price:</label>
		<input type='number' name='price' required /> <br/><br/>
		<br/><br/>
		<label>Description:</label>
		<textarea rows='3' name='description' required></textarea> <br/><br/>
		<button>Add Product</button>
	</form>
</body>
</html>
<% 
} 
%>