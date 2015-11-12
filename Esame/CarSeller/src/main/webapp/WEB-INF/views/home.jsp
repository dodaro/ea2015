<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page session="false" %>
<html>
<head>
	<title>Car Seller</title>

	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/scripts/jquery-ui-1.11.4.custom/jquery-ui.css' />">
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/styles/style.css' />">
	<script src="<c:url value='/resources/scripts/jquery-ui-1.11.4.custom/external/jquery/jquery.js' />"></script>
	<script src="<c:url value='/resources/scripts/jquery-ui-1.11.4.custom/jquery-ui.js' />"></script>
	<!-- <script src="<c:url value='/resources/scripts/script.js' />"></script> -->
	<script type="text/javascript">
	$(function() {
	$("button").button();
	$( "#radioset" ).buttonset();

	$("input[name='car']").click(function(){
		var choice = this.value;
		
		var path = "<c:url value='/resources/" + choice + ".html' />";
		
		$("#content").load(path,function() {
			$("#accordion").accordion();
		});

		$("#choosenmodel").attr("value",choice);
		

	});	
});
	</script>

</head>
<body>

<div class="container">
	<div class="header">
		<img id="banner" src="<c:url value='/resources/images/banner.jpg' />" />
	</div>
	<div class="buttons">
		<div id="radioset">
			<c:forEach  var="car" items="${cars}">	
				<input type="radio" id="${car.name}" name="car" value="${car.name}" ><label for="${car.name}"/>${car.label} (${car.price} euro)</label>
			</c:forEach>
			<input type="radio" id="asd"/>
		
		</div>
		
		
	
		<br>
			<form:form method="POST" modelAttribute="userOrder" action="color">
				<form:input id="choosenmodel" path="car" type="text" name="carmodel" value="" style="display:none"/>
				<button type="submit" >Next</button>
			</form:form >
	</div>



	<div id="content" class="content"></div>

	<div class="footer">
		Copyright 2015 Francesco Maida - <a href="http://www.fmaida.it">fmaida.it</a>
	</div>
</div>

</body>
</html>
