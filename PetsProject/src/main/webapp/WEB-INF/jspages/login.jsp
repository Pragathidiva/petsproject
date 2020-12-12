<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/contents/csspages/stylepage.css">
</head>
<body>
	<h3>PET PEERS</h3>
	<jsp:include page="menu.jsp" />
	<br>
	<form method="get">
		<div class="imgcontainer">
			<img
				src="${pageContext.request.contextPath}/contents/images/puppy.jpg"
				alt="Dogimage" class="avatar">
		</div>
		<div class="container">

			<form:form method="get" modelAttribute="user">

				<label>Enter Username:</label>
				<form:input path="username" placeholder="Enter Username" />
				<br>
				<label>Enter Password:</label>
				<form:password path="userPassword" placeholder="Enter Password" />
				<br>
				<button type="submit" value="submit" name="submit"
					formaction="./user/authenticate">SUBMIT</button>
				<button type="reset" value="reset" name="reset" formaction="./user">RESET</button>
			</form:form>
			<br>Not a member yet?<a href="./user/new"> please register</a>
		</div>
	</form>
</body>
</html>