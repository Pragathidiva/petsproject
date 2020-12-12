<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/contents/csspages/style_my_pets.css">
<style type="text/css">
</style>
</head>
<body>
	<h3>PET PEERS</h3>
	<h2>Hi, ${sessionuser.username}</h2>
	<jsp:include page="petmenu.jsp" />
	<div>
		<table class="center" id=pets>
			<thead>
				<tr>
					<th>Id</th>
					<th>Pet Name</th>
					<th>Age</th>
					<th>Place</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.pets}" var="pet">
					<tr>
						<td><c:out value="${pet.getId()}"></c:out></td>
						<td><c:out value="${pet.name}"></c:out></td>
						<td><c:out value="${pet.age}"></c:out></td>
						<td><c:out value="${pet.place}"></c:out></td>
						<c:choose>
							<c:when test="${empty pet.user}">
								<td><a href="./pets/buyPet?petId=${pet.getId()}">Buy</a></td>
							</c:when>
							<c:otherwise>
								<td>
									<button disabled="disabled">Sold</button>
								</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>