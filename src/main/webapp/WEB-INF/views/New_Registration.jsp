<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<h1>Register Here...</h1>
	<form action="saveReg" method="post">
		<pre>
	First Name<input type="text" name="firstName" />
	Last Name<input type="text" name="lastName" />
	Email<input type="email" name="email" />
	Mobile<input type="text" name="mobile" />
	<input type="submit" value="Save" />
	</pre>

	</form>
	${msg}

</body>
</html>
