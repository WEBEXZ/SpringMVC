<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<title>Spring MVC</title>
</head>
<body>
	<h2>Confirmation</h2>
	Successful user ${user.userName} created with the role ${user.role} and status active ${user.status}
	<br><br>
	Uses: 
	<ul>
		<c:forEach var="temp" items="${user.uses}">
			<li>${temp}</li>
		</c:forEach>
	</ul>
</body>
</html>