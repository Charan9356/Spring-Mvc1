<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Enter Details</h1>
		<%String msg = (String) request.getAttribute("msg");%>
		<%if(msg != null){ %>
		<h1 style="color:red; "><%=msg%></h1>
		<%}%>
	<form action="login">
				<input type="email" placeholder="enter email" name="email" >:Enter email
				<br>
				<br>
				<input type="password" placeholder="enter password" name="pwd" required >:Enter password
				<br>
				<br>
				<button>Login</button>
	</form>
</body>
</html>