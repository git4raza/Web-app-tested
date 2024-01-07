<%@page import="com.webapp.entity.Registration"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="Menu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Registration</title>

</head>
<body>
	<form action="getAllReg"></form>
	<table border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>

		<c:forEach var="reg" items="${reg}">
			<tr>
				<td>${reg.firstName}</td>
				<td>${reg.lastName}</td>
				<td>${reg.email}</td>
				<td>${reg.mobile}</td>
				<td><a href="delete?id=${reg.id}">Delete</a></td>
				<td><a href="getRegistrationById?id=${reg.id}">Update</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>