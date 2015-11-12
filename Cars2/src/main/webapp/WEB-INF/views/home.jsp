<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<title>Cars</title>
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
	  $(function() {
    $( "#accordion" ).accordion({
      collapsible: true
    });
  });
</script>
</head>
<body>
<h1>
	Welcome!
</h1>
	<div id="content">
	<form:form id="form" action="#" method="post" commandName="buy">
	<table>
	<tr><td>
	<form:checkbox id="se" path="products" value="SE"/>
	<label for="se">SE (11000 euro)</label>
	<form:checkbox id="se a/l" path="products" value="SE A/L"/>
	<label for="se a/l">SE A/L (12400 euro)</label>
	<form:checkbox id="sl" path="products" value="SL"/>
	<label for="sl">SL (15000 euro)</label>
	</td></tr>
	</table>
	<div id="accordion">
  <h3>Comfort/Convenience</h3>
  <div>
    <p>
    <ul>
    <li>sadfhkasdfhkjasdhf</li>
    <li>asdfaksdfjklasdjfl</li>
    <li>asdfkashdfasdf</li>
    <li>adsfjaskldfjas</li>
    </ul>
    </p>
  </div>
    <h3>Security</h3>
  <div>
<p>
<ul>
    <li>sadfhkasdfhkjasdhf</li>
    <li>asdfaksdfjklasdjflk</li>
    <li>asdfkashdfasdf</li>
    <li>adsfjaskldfjas</li>
    </ul>
    </p>
  </div>
  <h3>Features</h3>
  <div>
<p>
<ul>
    <li>sadfhkasdfhkjasdhf</li>
    <li>asdfaksdfjklasdjflk</li>
    <li>asdfkashdfasdf</li>
    <li>adsfjaskldfjas</li>
    </ul>
    </p>
  </div>
	</form:form>
	<button id="show">Next</button>
	
</body>
</html>