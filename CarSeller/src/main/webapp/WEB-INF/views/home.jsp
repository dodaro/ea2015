<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/jquery-ui-1.11.4/jquery-ui.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/Style/style.css' />">
<script
	src="<c:url value='/resources/jquery-ui-1.11.4/external/jquery/jquery.js' />"></script>
<script src="<c:url value='/resources/jquery-ui-1.11.4/jquery-ui.js' />"></script>


<script>
	$(document).ready(function() {
		$("#sub").button();
	});
	$(document).ready(function() {
		$("#radios").buttonset();
	});

	$(document).ready(function() {
		$("#form input").on('change', function() {

			var selected = $("input[type=radio]:checked");
			var page = selected.val() + ".html";
			$("#details").html("./" + page);
			$("#details").load("/WEB-INF/views/" + page);
		});
	});
	
	$(document).ready(function() {
		$("#sub").on('click', function() {

			var selected = $("#form input[type=radio]:checked");
			alert(selected.val());
			
		});
	});
</script>
</head>
<body>
	<h1 id="header"></h1>
	<div id="selectCar">
		<form:form id="form" modelAttribute="sell" method="post"
			commandName="sellerForm">
			<p id="radios">
				<form:radiobutton id="SE" path="car" value="SE" />
				<label for="SE">SE (15000 euro)</label>
				
				<form:radiobutton id="SL" path="car" value="SL" />
				<label for="SL">SL (12400 euro)</label>
				
				<form:radiobutton id="SEA" path="car" value="SEA" />
				<label for="SEA">SEA (11000 euro)</label>
			</p>
			<p id="subP">
				<input id="sub" type="submit" value="Start">
			</p>
		</form:form>


	</div>
	<div id="details"></div>
</body>
<footer>No one really reads the footer</footer>
</html>
