<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Spring MVC</title>
</head>
<body>
	<h2>User</h2>
	<form:form action="processForm" modelAttribute="user">
		User: <form:input path="userName"/>
		<br><br>
		Password: <form:password path="password"/>
		<br><br>
		Role: 
		<form:select path="role">
			<form:options items="${user.roles}"/>
		</form:select>
		<br><br>
		Is Active?
		<form:radiobuttons path="status" items="${user.statusOptions}"/>
		<br><br>
		<form:checkboxes items="${user.useOptions}" path="uses"/>
		<br><br>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>