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
			var img=selected.val();
			$("#preview").html("<img id=\"showImage\" /img> ");
			var path= "/resources/Images/"+img+".png";
			$("#showImage").attr("src", path);
			$("#showImage").show();
		});
	});
</script>
</head>
<body>
	<h1 id="header"></h1>
	<div id="selectColor">
		<form:form id="form" modelAttribute="sell" method="post"
			commandName="colorForm">
			<p id="radios">
				<form:radiobutton id="RED" path="color" value="RED" />
				<label for="RED">RED (300 euro)</label>
				<form:radiobutton id="BLUE" path="color" value="BLUE" />
				<label for="BLUE">BLUE (500 euro)</label>
				<form:radiobutton id="GREEN" path="color" value="GREEN" />
				<label for="GREEN">GREEN (450 euro)</label>
			</p>
			<p id="subP">
				<input id="sub" type="submit" value="Start">
			</p>
		</form:form>


	</div>
	<div id="preview"></div>
</body>
</html>