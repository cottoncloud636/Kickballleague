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
<title>Team Details</title>

<link rel="stylesheet" href="/css/styles.css"> 

</head>

<body>
<div class="teamcontainer">
	<div>
		<h1><c:out value="${team.teamName}"/></h1>
		<a href="/home">dashboard</a>
	</div>
	
	<div>
	

		<p>Team Name: <c:out value="${team.teamName}"></c:out></p>
		<p>Skill Level: <c:out value="${team.skillLevel}"/></p>
		<p>Game Day: <c:out value="${team.gameDay}"/></p>
	
	
	</div>	
	
	<a href="/teams/${team.id}/edit">edit</a>
	
	<form action="/teams/${team.id}" method="post">
    	<input type="hidden" name="_method" value="delete">
    	<input type="submit" value="delete" class="teamdelete">
	</form>
</div>
</body>
</html>