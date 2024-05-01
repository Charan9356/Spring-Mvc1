<%@page import="spring_mvc2.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%List<Employee> list = (List<Employee>)request.getAttribute("list"); %>
		<table border="2px solid black">
		<tr>
		<th>Id </th>
		<th>Name </th>
		<th>Phone </th>
		<th>Email </th>
		<th>UPDATE</th>
		<th>DELETE</th>
		</tr> 
		<% for(Employee e:list){%>
		
		<tr>
		<td><%=e.getId() %></td>
		<td><%=e.getName()%></td>
		<td><%=e.getPhone()%></td>
		<td><%=e.getEmail() %></td>
		<td><a href="update?id=<%=e.getId() %>"><button>UPDATE</button></a></td>
		<td><a href="delete?id=<%=e.getId() %>"><button>DELETE</button></a></td>
		<%} %>
		</table>

</body>
</html>