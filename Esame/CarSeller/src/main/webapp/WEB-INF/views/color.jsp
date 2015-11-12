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

	$("input[name='color']").click(function(){
		var choice = this.value;
		
		var path = "<c:url value='/resources/images/" + choice + ".jpg' />";
		
		
		var img = "<img src=\" " + path + " \" width=\"300\" heigth=\"300\" />";
		
		$("#content").html(img);
		

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
			<c:forEach  var="color" items="${colors}">	
				<input type="radio" id="${color.name}" name="color" value="${color.name}" ><label for="${color.name}"/>${color.name} (${color.price} euro)</label>
			</c:forEach>
			<input type="radio" id="asd"/>
		
		</div>
		
		
	
		<br>
			<form:form action="review" modelAttribute="userOrder" method="POST" >
				<form:input style="display:none" path="car" type="text" name="car" value="" />
				<form:input id="choosenmodel" style="display:none" path="color" type="text"  value="" />
				<button  type="submit" >Next</button>
			</form:form >
	</div>



	<div id="content" class="content"></div>

	<div class="footer">
		Copyright 2015 Francesco Maida - <a href="http://www.fmaida.it">fmaida.it</a>
	</div>
</div>

</body>
</html>
