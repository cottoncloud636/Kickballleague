<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kickball League</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="/css/styles.css"> 

<!-- for Registration and Login page -->

</head>
<body>

<div class="container">
	<h1>Welcome!</h1>
	
		<h2>Register</h2>
		<form:form action="/register" method="post" modelAttribute="newUser">
		
		<table class="table table-bordered">
		<tr>
		<th><form:label path="userName">User Name:</form:label></th>
		<form:errors path="userName"/>
		<td><form:input path="userName" type="text"/></td>
		</tr>
		
		<tr>
		<th><form:label path="email">Email:</form:label></th>
		<form:errors path="email"/>
		<td><form:input path="email" type="text"/></td>
		</tr>
		
		<tr>
		<th><form:label path="password">Password:</form:label></th>
		<form:errors path="password"/>
		<td><form:input path="password" type="password"/></td>
		</tr>
		
		<tr>
		<th><form:label path="confirm">Confirm PW:</form:label></th>
		<form:errors path="confirm"/>
		<td><form:input path="confirm" type="password"/></td>
		</tr>
		
		</table>
		<button>Register</button>
		</form:form>
	

	
		<h1>Log In</h1>
		<form:form action="/login" method="post" modelAttribute="newLogin">
		
		<table class="table table-bordered">
			<tr>
				<th><form:label path="email">Email:</form:label></th>
				<form:errors path="email"/>
				<td><form:input path="email" type="text"/></td>
			</tr>
		
			<tr>
				<th><form:label path="password">Password:</form:label></th>
				<form:errors path="password"/>
				<td><form:input path="password" type="password"/></td>
			</tr>
		</table>
			<button>Log In</button>
		</form:form>

	

</div>
</body>
</html>