<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ProductApp</h1>
	<hr>
	<p>
		<a href="index.jsp">Home</a> &nbsp;&nbsp;&nbsp;&nbsp;
		<a href="Login.jsp">Admin-Login</a>
	</p>
	<hr>
	<h3>Admin Login</h3>
	<%
		String msg=(String)session.getAttribute("msg");
		if(msg!=null){
	%>
			<p style="color:red;"> <%=msg %> </p>
	<%		
			session.setAttribute("msg", null);
		}
	%>
	<form action="AdminLogin" method="post">
		<label>ID:</label>
		<input type="text" name="id" required /> <br/><br/>
		<label>Password:</label>
		<input type="password" name="password" required /> <br/><br/>
		<button>Login</button>
	</form>
</body>
</html>