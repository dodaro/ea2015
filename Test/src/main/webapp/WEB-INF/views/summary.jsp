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

	<div id="header">
		<h1>Summary</h1>
	</div>

	<div id="section">
		<div class="central">
			<table>
				<tr>
					<th>Model:</th>
					<th>${type}</th>
				</tr>
				<tr>
					<td>Color:</td>
					<td>${color}</td>
				</tr>
				<tr>
					<td>Total:</td>
					<td>${total}</td>
				</tr>
			</table>
		</div>
	</div>

	<div id="footer">Copyright © BigAldo</div>
</body>
</html>
