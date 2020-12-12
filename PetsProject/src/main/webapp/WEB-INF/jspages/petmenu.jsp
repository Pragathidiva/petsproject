<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/csspages/stylepetmenu.css">
</head>
<body>
	<div class="menu">
		<a href="${pageContext.request.contextPath}/user">Log Out</a> <a
			href="${pageContext.request.contextPath}/pets/petDetail">Add Pet</a>
		<a href="${pageContext.request.contextPath}/pets/myPets">My Pets</a> <a
			href="${pageContext.request.contextPath}/pets">Home</a>
	</div>
</body>
</html>