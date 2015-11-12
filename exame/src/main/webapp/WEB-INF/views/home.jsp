<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<title>Buy a car</title>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/script/jquery-ui-1.11.4/jquery-ui.css' />">
  	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/style/style.css' />">
	<script src="<c:url value='/resources/script/jquery-ui-1.11.4/external/jquery/jquery.js' />"></script>
	<script src="<c:url value='/resources/script/jquery-ui-1.11.4/jquery-ui.js' />"></script>
	
	<script>
	$(document).ready(function() {
		$("#button").button();
		$("#show").button();
	});
	
	$(document).ready(function() {
		$("#form").buttonset();
	});
	
	$(document).ready(function() {
		$('#show').on('click', function() {
			var v = $("input[type=checkbox]:checked", "#form").val();
			alert(v);
			$("#result").load("<c:url value='/resources/info.html' />");						
		});
	});
</script>
</head>
<body>
<h1>
	Welcome!
</h1>
	<div id="wrapper">
	<form:form id="form" action="#" method="post" commandName="buy">
	<table>
	<tr><td>
	<form:checkbox id="" path="products" value="SE (11000.0 euro)"/>
	<label for="coffee">products SE (11000.0 euro)</label>
	<form:checkbox id="milk" path="products" value="(A/L12000.0 euro)"/>
	<label for="milk">products (A/L12000.0 euro)</label>
	<form:checkbox id="vodka" path="products" value="products"/>
	<label for="vodka">Vodka (15000.0 euro))</label>
	</td></tr>
	<tr><td>Add money here: <form:input path="insertedMoney" /></td></tr>
	<tr><td>${result}</td></tr>
	</table>
	<table>
	<tr><td><input id="button" type="submit" name="ComputeChange" value="Buy" /></td></tr>
	</table>
	</form:form>
	<button id="show">Show</button>
	</div>
	<div id="result">
	<p>Load an external page here</p>
	</div>
</body>
</html>
