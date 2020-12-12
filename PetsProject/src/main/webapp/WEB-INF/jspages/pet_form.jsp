<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PETS APP</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/contents/csspages/stylepage.css">
</head>
<body>
	<h3>PET PEERS</h3>
	<h2>Hi, ${sessionuser.username}</h2>
	<jsp:include page="petmenu.jsp" />

	<form:form method="get" modelAttribute="pet">
		<table>
			<tr>
				<td><label>Pet Name</label></td>
				<td><form:input path="name" placeholder="Enter Name" /></td>
			</tr>
			<tr>
				<td><label>Age</label></td>
				<td><form:input path="age" placeholder="Enter Age" /></td>

			</tr>
			<tr>
				<td><label>Place</label></td>
				<td><form:input path="place" placeholder="Enter Place" /></td>
			</tr>
		</table>
		<button type="submit" name="save" value="save" formaction="./addPet">Save</button>
		<button type="submit" name="cancel" value="cancel"
			formaction="./petDetail">Cancel</button>
	</form:form>
</body>
</html>