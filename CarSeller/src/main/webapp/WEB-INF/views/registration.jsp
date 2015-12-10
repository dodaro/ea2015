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
		$("#button").button();
	});
	
	$(document).ready(function() {
		$("#footer").load("/resources/footer.html");
	});
</script>
</head>
<body>
	<div id="wrapper">
		<div id="header"></div>

		<div id="content">						
			<form:form id="form" action="#" method="post" commandName="userForm">
				<table>
					<tr><td><label for="username">Username </label></td><td><form:input id="username" path="username" /></td><td><form:errors path="username" cssClass="error"/></td></tr>					
					<tr><td><label for="password">Password </label></td><td><form:password id="password" path="password"/></td><td><form:errors path="password" cssClass="error"/></td></tr>
					<tr><td><label for="email">Email </label></td><td><form:input id="email" path="email"/></td><td><form:errors path="email" cssClass="error"/></td></tr>
					<tr><td><label for="age"><spring:message code="message.age" text="default text"/></label></td><td><form:input id="age" path="age"/></td><td><form:errors path="age" cssClass="error"/></td></tr>
					<tr><td><label for="dateOfBirth"><spring:message code="message.birthday" text="default text"/></label></td><td><form:input id="dateOfBirth" path="dateOfBirth"/></td><td><form:errors path="dateOfBirth" cssClass="error"/></td></tr>
				</table>
				<table>
					<tr>
						<td><input id="button" class="button" type="submit" value="<spring:message code='message.register' text='default text'/>"></td>
					</tr>
				</table>
			</form:form>
			<div id="inner">${error}</div>						
		</div>		

		<div id="footer"></div>
	</div>
</body>
</html>