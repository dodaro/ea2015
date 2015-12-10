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
		$(".button").button();		
	});
	
	$(document).ready(function() {
		$("#footer").load("/resources/footer.html");
	});

	$(document).ready(function() {
		$("#header").load("/resources/header.html");
	});
	
	$(document).ready(function(){
		$("#redirect").click(function(){
			window.location.replace("/registration");
		});
	});	
</script>
</head>
<body>
	<div id="wrapper">
		<div id="header">
		<table>
		<tr>
			<td>
			<form>
		  		<input type="hidden" name="locale" value="it" /> 
		  		<input type="submit" class="button" value="IT"/>
		  	</form>
		  	</td>
			<td>
			<form>
		  		<input type="hidden" name="locale" value="en" />
		  		<input type="submit" class="button" value="EN"/>
		  	</form>
			</td>
		</tr>
		</table>		  
		 </div>

		<div id="content">						
			<form:form id="form" action="#" method="post" commandName="userForm">
				<table>
					<tr><td><label for="username">Username </label></td><td><form:input id="username" path="username" /></td></tr>
					<tr><td><label for="password">Password </label></td><td><form:password id="password" path="password"/></td></tr>				
				</table>
				<table>
					<tr>
						<td><input id="button" class="button" type="submit" value="Login" /></td>
						<td><button id="redirect" class="button" type="button"><spring:message code="message.register" text="default text" /></button></td>
					</tr>
				</table>
			</form:form>
			<div id="inner">${error}</div>						
		</div>

		<div id="footer"></div>
	</div>
</body>
</html>