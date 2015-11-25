<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/eaStyle.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" type="text/css"
	href="js/jquery-ui-1.11.4/jquery-ui.min.css">
<script src="js/jquery-ui-1.11.4/external/jquery/jquery.js"></script>
<script src="js/jquery-ui-1.11.4/jquery-ui.min.js"></script>
<script>
	$(document).ready(function() {
		$("#tabs").tabs();
	});
</script>
<title>Color Select Page</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="body">
		<div id="tabs">
			<ul>
				<c:forEach items="${productsColorList.productsColor}" var="singleProductColor">
					<li><a href="#tabs-${singleProductColor.name}">${singleProductColor.name}</a></li>
				</c:forEach>
			</ul>
			<c:forEach items="${productsColorList.productsColor}" var="singleProductColor">
				<div id="tabs-${singleProductColor.name}">
					<form:form method="post" commandName="productColorSelect">	
						<input type="text" name="nameProductColor" value="${singleProductColor.name}" hidden="true"/>					
						<input type="submit" name="ProductColorSelectSubmitButton" value="Next" />
						<p>${singleProductColor.name} - Price: euro ${singleProductColor.price}</p>
						<img src="${singleProductColor.imagePath}">
					</form:form>
				</div>
			</c:forEach>
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>