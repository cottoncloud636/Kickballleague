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
<title>Kickball League Dashboard</title>

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
		<h1>Welcome, <c:out value="${user.userName}"/></h1>
		<a href="/">log out</a>
	</div>
	
	<table class="table table-striped">
		<tr>   <!-- table row -->
			<th>Team Name</th>  <!-- table header -->
			<th>Skill Level(1-5)</th>
			<th>Game Day</th>
		</tr>
		
	<c:forEach var="team" items="${teams}">   <!-- "teams" came from MainController.java line 72 -->
		<tr>
			<td><a href="teams/${team.id}"><c:out value="${team.teamName}"/></a></td>
			<td><c:out value="${team.skillLevel}"/></td>
			<td><c:out value="${team.gameDay}"/></td>
		</tr>	
	</c:forEach>
	</table>		

	<a href="/teams/new"><button>Create New Team</button></a>
</div>
</body>
</html>