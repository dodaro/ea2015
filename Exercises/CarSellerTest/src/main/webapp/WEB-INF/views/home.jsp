<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/resources/style/styleArt.css">
<link rel="stylesheet" type="text/css" href="/resources/script/jquery-ui-1.11.4/jquery-ui.css">
<script src="/resources/script/jquery-ui-1.11.4/external/jquery/jquery.js"></script>
<script src="/resources/script/jquery-ui-1.11.4/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		$("#form :radio:first").prop('checked', true);
		$("#listart").load("<c:url value='/resources/se.html' />");
	});

	$(document).ready(function() {
		$("#form").buttonset();
	});

	$(document).ready(function() {
		$("#form :radio").click(function() {
			if ($(this).is(':checked')) {
				var ck = $(this).val();
					if (ck == "SE") {
						$("#listart").load("<c:url value='/resources/se.html' />");
					} 
					else if (ck == "SE A/L") {
						$("#listart").load("<c:url value='/resources/sea.html' />");
					} 
					else if (ck == "SL") {
						$("#listart").load("<c:url value='/resources/sl.html' />");
					}
			}
		});
	});


	$(document).ready(function() {
		$("#slide-up").click(function() {
			$("#hidden").slideUp("slow");
		});
	});
	
</script>
</head>

<body>
	<div id="wrapper">
		<div id="header"></div>

		<div id="content">

			<h1>Choose your model!</h1>	
			<form:form id="form" method="POST" action="#" commandName="response">
				<form:radiobuttons path="modelChoosed" items="${carsList}"
					itemValue="model" />
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
