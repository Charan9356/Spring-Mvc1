<%@page import="spring_mvc2.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%Employee e = (Employee)request.getAttribute("db"); %>
		<%=e %>
		<form action="edit">
		
		<input type="text"  name="id" readonly="readonly" value="<%=e.getId()%>">:enter id
				<br>
				<br>
				<input type="text"  name="name" value="<%=e.getName()%>" >:enter name
				<br>
				<br>
				<input type="email"  name="email" value="<%=e.getEmail()%>" >:enter email
				<br>
				<br>
				<input type="number"  name="phone" value="<%=e.getPhone()%>">:enter phone
				<br>
				<br>
				<input type="password" name="pwd" value="<%=e.getPwd()%>">:enter password
				<br>
				<br>
			<br>
		<input type="submit" value="update">
		
		</form>
</body>
</html>