<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/default.css' />">
<link rel="stylesheet" type="text/css"
	href="resources/script/jquery-ui-1.11.4/jquery-ui.css">
<script
	src="resources/script/jquery-ui-1.11.4/external/jquery/jquery.js"></script>
<script src="resources/script/jquery-ui-1.11.4/jquery-ui.js"></script>
<script src="resources/script/functions.js"></script>

</head>
<body>

	<div id="header"></div>

	<div id="section">
		<div id="buttons">
			<c:forEach var="product" items="${products}">
				<form:form action="/firstPage" method="post" commandName="Choice">
					<form:input type="hidden" path="choice" value="${product.name}" />
					<form:input type="hidden" path="price" value="${product.price}" />
					<input type="submit" value="${product.name}">
				</form:form>
			</c:forEach>
		</div>


		<form:form action="/secondPage" method="post" commandName="Choice">
			<form:input type="hidden" path="choice"
				value="${productSelected}" />
			<input type="submit" value="next">
		</form:form>

	</div>

	<div id="footer">Copyright © BigAldo</div>
</body>
</html>
