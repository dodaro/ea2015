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
<title>Product Review Page</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="body">
	<h1 class="orangeText centred"> Shopping items: </h1>
	<h2 class="blueText centred"> User: ${sessionScope.userSession.name} </h2>
	<ul class="centred">
		<li> ${sessionScope.userSession.productSelected.name} </li>
		<li> ${sessionScope.userSession.productColorSelected.name} </li>
		<li> 
			<img src="${sessionScope.userSession.productColorSelected.imagePath}">
		</li>
		<li> Total price: ${sessionScope.userSession.productSelected.price +  sessionScope.userSession.productColorSelected.price}  </li>
	</ul>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>