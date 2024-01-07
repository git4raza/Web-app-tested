<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Registration...</title>
</head>
<body>
	<h1>Update Here...</h1>
	<form action="updateReg" method="post">
		<pre>
	<input type="hidden" name="id" value="${reg.id}" />
	First Name<input type="text" name="firstName" value="${reg.firstName}" />
	Last Name<input type="text" name="lastName" value="${reg.lastName}" />
	Email<input type="email" name="email" value="${reg.email}" />
	Mobile<input type="text" name="mobile" value="${reg.mobile}" />
	
	<input type="submit" value="Update" />
	</pre>

	</form>
	${omg}
</body>
</html>
