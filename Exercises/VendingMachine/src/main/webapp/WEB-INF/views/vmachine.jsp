<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Vendor Machine</title>
</head>
<body>
	<h1>Vendor Machine</h1>
	<form:form method="post" commandName="vmachineAction">
		<div>
			<form:radiobuttons items="${vmachineAction.goodies}" itemValue="price"
				path="purchased" element="li" />
			
		</div>
		<p>
			money:
			<form:input path="money"/>
		</p>

		<p>
			<input type="submit" name="change" value="Buy" />
			<input type="submit" name="change" value="Change" />
		</p>

	</form:form>

	<p>${messageOut}</p>

</body>
</html>
