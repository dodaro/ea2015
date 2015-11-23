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
	$(document).ready(function() {
		$("#form :radio:first").prop('checked', true);
		$("#listart").load("<c:url value='/resources/description/se.html' />");
	});

	$(document).ready(function() {
		$("#form").buttonset();
	});

	$(document).ready(function() {
		$("#form :radio").click(function() {
			if ($(this).is(':checked')) {
				var ck = $(this).val();
					if (ck == "1") {
						$("#listart").load("<c:url value='/resources/description/se.html' />");
					} 
					else if (ck == "2") {
						$("#listart").load("<c:url value='/resources/description/sea.html' />");
					} 
					else if (ck == "3") {
						$("#listart").load("<c:url value='/resources/description/sl.html' />");
					}
			}
		});
	});
	
</script>
</head>

<body>
	<div id="wrapper">
		<div id="header"></div>

		<div id="content">

			<h1>Choose your model!</h1>	
			<form:form id="form" method="POST" action="color" commandName="carIndex">
				<form:radiobuttons path="response" items="${cars.carMap}"/>
				<p>
					<input type="submit" name="change" value="Next" />
				</p>
			</form:form>

			<div id="listart"></div>

		</div>
		<div id="footer">Enterprise Applications - Department of
			Mathematics and Computer Science - University of Calabria -
			Arcavacata di Rende (CS) - Italy</div>
	</div>
</body>
</html>
