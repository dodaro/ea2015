<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<h1>Login</h1>

	<form:form action="login" method="post" commandName="userForm">
		<p>
			User Name: <form:input path="username" />
		</p>
		<p>
			Password : <form:password path="password" />
		</p>
		<p>
			<input type="submit" value="Login" />
		</p>
	</form:form>
</body>
</html>