<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="resources/js/home.js"></script>

<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="resources/css/home.css" type="text/css">
<link rel="stylesheet" href="resources/css/navbar.css" type="text/css">

<title>OnlineStore</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/includes/navbar.jsp"%>
	<div id="container">

		<h2>Benvenuto nello store!</h2>

		<c:forEach items="${items}" var="item">
			<c:if test="${cart.contains(item)}">
				<c:set var="inCart" value="true" />
			</c:if>
			<div class="item" data-id="${item.id}">
				<div class="item-info">
					<div class="image-container">
						<img src="resources/img/tv.png" />
					</div>
					<div>
						<div class="item-name">${item.name}</div>
						<div class="item-price">${item.price}</div>
					</div>
				</div>
				<div class="buttons-container">
					<button class="cart-button" ${inCart ? 'disabled' : ''} >Add to cart</button>
					<input type="number" class="cart-quantity" value="1" ${inCart ? 'disabled' : ''} />
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>
