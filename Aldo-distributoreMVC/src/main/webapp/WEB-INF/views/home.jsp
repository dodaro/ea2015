<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h2>Choose your products!</h2>

<form:form action="/buy" method="post" commandName="Purchase">
<ul>
<form:checkboxes element="li" items="${Distributore.getProducts()}" itemLabel="label" itemValue="id" path="selected" ></form:checkboxes>
</ul>
<p> Coins:<form:input type="number" path="coins" /></p>
<p> <input type="submit" value="buy" /> </p>                   
</form:form>

<c:out value="${message}"/>

</body>
</html>
