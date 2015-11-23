<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/resources/style/styleArt.css">
<link rel="stylesheet" type="text/css" href="/resources/lib/jquery-ui-1.11.4/jquery-ui.css">
<script src="/resources/lib/jquery-ui-1.11.4/external/jquery/jquery.js"></script>
<script src="/resources/lib/jquery-ui-1.11.4/jquery-ui.js"></script>
<script>

</script>
</head>

<body>
	<div id="wrapper">
		<div id="header"></div>

		<div id="content">
			<h1>Summary:</h1>
			<table>
				<tr>
					<th>Your Car</th>
				</tr>
				<tr>
					<td>Model: ${model}</td>
				</tr>
				<tr>
					<td>Color: ${color}</td>
				</tr>
				<tr>
					<td>Total price: ${price}</td>
				</tr>
			</table>
		</div>
		<div id="footer">Enterprise Applications - Department of
			Mathematics and Computer Science - University of Calabria -
			Arcavacata di Rende (CS) - Italy</div>
	</div>
</body>
</html>
