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
		$("#content").buttonset();
	});	
	$(document).ready(function() {
		$('#form input').on('change', function() {
			var v = $("input[type=radio]:checked", "#form").attr("urlPage");
			$("#result *").remove();
			$("#result").load("/resources/"+v);		
		});
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
			<form:form id="form" action="#" method="post" commandName="selectModel">
				<table>
					<tr><td>
					<c:if test="${not empty allCarModels}">
						<c:forEach var="m" items="${allCarModels}">
							<form:radiobutton id="${m.name}" urlPage="${m.htmlPage}" path="name" value="${m.name}" />
							<label for="${m.name}">${m}</label>
						</c:forEach>					
					</c:if>
					</td></tr>
				</table>
				<table>
					<tr>
						<td><input id="button" class="button" type="submit" value="<spring:message code='message.next' text='default text'/>"/></td>
					</tr>
				</table>
			</form:form>
			<div id="result"></div>			
		</div>

		<div id="footer"></div>
	</div>
</body>
</html>