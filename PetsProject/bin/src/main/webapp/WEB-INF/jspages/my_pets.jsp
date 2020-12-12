<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PETS APP</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/contents/csspages/style_my_pets.css">
</head>
<body>
	<h3>PET PEERS</h3>
	<h2>${sessionuser.username}'s&nbsp;Pets</h2>
	<jsp:include page="petmenu.jsp" />
	<div>
		<table class="center" id="pets">
			<tbody>
				<tr>
					<th>Petname</th>
					<th>Place</th>
					<th>Age</th>
				</tr>
				<c:forEach items="${requestScope.pets}" var="pet">
					<tr>
						<td><c:out value="${pet.name}"></c:out></td>
						<td><c:out value="${pet.age}"></c:out></td>
						<td><c:out value="${pet.place}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>