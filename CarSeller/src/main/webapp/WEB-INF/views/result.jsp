<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/jquery-ui-1.11.4/jquery-ui.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/Style/style.css' />">
<script
	src="<c:url value='/resources/jquery-ui-1.11.4/external/jquery/jquery.js' />"></script>
<script src="<c:url value='/resources/jquery-ui-1.11.4/jquery-ui.js' />"></script>


</head>
<body>
	<h1 id="header"></h1>
	<div id="showresult">
		<table id="results">
			<tr>
				<td>Car</td>
				<td></td>
			</tr>
			<tr>
				<td>Color</td>
				<td></td>
			</tr>
			<tr>
				<td>Total</td>
				<td></td>
			</tr>
		</table>


	</div>
</body>
</html>
