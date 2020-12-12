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
	<jsp:include page="menu.jsp" />
	<form method="get">
		<br>
		<div class="imgcontainer">
			<img
				src="${pageContext.request.contextPath}/contents/images/puppy.jpg"
				alt="Dogimage" class="avatar">
		</div>

		<div class="container">
			<table>
				<form:form method="get" modelAttribute="user">
					<label>Enter Username:</label>
					<form:input path="username" placeholder="Enter Username" />
					<form:errors path="username" cssClass="error" />
					<br>
					<label>Enter Password:</label>
					<form:password path="userPassword" placeholder="Enter Password" />
					<form:errors path="userPassword" cssClass="error" />
					<br>
					<label>Confirm Password:</label>
					<form:password path="confirmPassword"
						placeholder="Confirm Password" />
					<br>
					<button type="submit" name="submit" value=submit formaction="./add">Submit</button>
				</form:form>
			</table>
		</div>
	</form>

</body>
</html>