<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Car Seller</title>
	<link rel="stylesheet" type="text/css" href="/resources/script/jquery-ui-1.11.4/jquery-ui.css">
  	<link rel="stylesheet" type="text/css" href="/resources/style/style.css">
	<script src="/resources/script/jquery-ui-1.11.4/external/jquery/jquery.js"></script>
	<script src="/resources/script/jquery-ui-1.11.4/jquery-ui.js"></script>
	<script>
	$(document).ready(function() {
		$("#footer").load("/resources/footer.html");
	});
	</script>
</head>
<body>	
	<div id="wrapper">
  		<div id="header">
		</div>

		<div id="content">
			  <div id="inner">			  				 
				  <table id="summaryTable">
				  	<tr><th colspan="2" align="center"><spring:message code="message.selection" text="default text"/></th></tr>				  
				  	<tr><td><b><spring:message code="message.model" text="default text"/>:</b> </td><td class="myTd">${carModel}</td></tr>
				  	<tr><td><b><spring:message code="message.color" text="default text"/>:</b> </td><td class="myTd">${carColor}</td></tr>
				  	<tr><td><b><spring:message code="message.price" text="default text"/>:</b> </td><td class="myTd">${totalPrice} euro</td></tr>			  				   
				  </table>
			  </div>
		</div>
	
		<div id="footer">		
		</div>
	</div>	
	
</body>
</html>