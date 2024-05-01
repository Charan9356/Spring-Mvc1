<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form action="save">
			<fieldset>
			<legend>Register-form</legend>
				<input type="text" placeholder="enter name" name="name" >:Enter name
				<br>
				<br>
				<input type="email" placeholder="enter email" name="email" >:Enter email
				<br>
				<br>
				<input type="password" placeholder="enter password" name="pwd" required >:Enter password
				<br>
				<br>
				<input type="number" placeholder="enter phone" name="phone" >:Enter phone
				<br>
				<br>
				<button>Register</button>
			</fieldset>
		</form>
</body>
</html>