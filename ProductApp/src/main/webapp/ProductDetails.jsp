<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
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
	<%
		ArrayList<HashMap> users=(ArrayList<HashMap>)request.getAttribute("users");
		if(users.isEmpty()){
	%>
			<p style='color:red;'>Product Not Found!</p>
	<%		
		}else{
			for(HashMap<String, Object> product:users) {
	%>
				<div style='background-color:yellow; padding:20px; margin:10px'>
					<p>companyName: <%=product.get("companyname")%></p>
					<p>name: <%=product.get("name")%></p>
					<p>price: <%=product.get("price")%></p>
					<p>description: <%=product.get("description")%></p>
				</div>
	<%		
			}
		}
	%>
</body>
</html>