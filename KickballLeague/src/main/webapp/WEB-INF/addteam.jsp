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
<title>Create New Team</title>


<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="/css/styles.css"> 
</head>

<body>
<div class="container">
	<div class="container1">
		<h1>New Team</h1>
		<a href="/home">dashboard</a>
	</div>
	
	<form:form action="/teams" modelAttribute="team" method="post">
		<table class="table table-bordered">
			<tr>
				<th><form:label path="teamName">Team Name</form:label></th>
			 	<form:errors path="teamName"/>
				<td><form:input type="text" path="teamName"/></td>
			</tr>
			
			<tr>
				<th><form:label path="skillLevel">Skill Level(1-5)</form:label></th>
			 	<form:errors path="skillLevel"/>
				<td><form:input path="skillLevel" type="number" min="1" max="5" /></td>
			</tr>
			
			<tr>
				<th><form:label path="gameDay">Game Day:</form:label></th>
			 	<form:errors path="gameDay"/>
				<td><form:input path="gameDay" type="text"/></td>
			</tr>
			
			<div class="adddiv">
				<form:errors path="registration"/>
				<form:input type="hidden" path="registration" value="${registration.id}"/>
			</div>
		
		</table>
		<button class="addbtn">Submit</button>
		</form:form>

</div>
</body>
</html>