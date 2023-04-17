<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ProductApp</title>
</head>
<body>
<h1>ProductApp</h1>
	<hr>
	<p>
		<a href="index.jsp">Home</a> &nbsp;&nbsp;&nbsp;&nbsp;
		<a href="Login.jsp">Admin-Login</a>
	</p>
	<hr>
	<h3>Search Product</h3>
	<form action="SearchProduct" method="post">
		<label>Name:</label>
		<input type="text" name="name" required /> <br/><br/>
		<button>Search</button>
	</form>
</body>
</html>