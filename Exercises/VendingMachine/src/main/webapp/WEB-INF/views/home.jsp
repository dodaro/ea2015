<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>

<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="resources/css/home.css" type="text/css" />

<title>Vending Machine</title>
</head>
<body>
	<div id="container">
		<div id="coins">
			<div>
				<span class="coin" data-value="10">0.10</span>
				<span class="coin" data-value="20">0.20</span>
				<span class="coin" data-value="50">0.50</span>
			</div>
			<div>
				<span class="coin" data-value="100">1.00</span>
				<span class="coin" data-value="200">2.00</span>
			</div>
		</div>
		<div id="machine">
		
			<form:form action="" modelAttribute="purchaseForm">
			
				<div id="products">
					<c:forEach items="${purchaseForm.products}" var="product" varStatus="i">
					<form:checkbox id="${product.name}" class="hidden" path="products[${i.index}].selected" value="true"/>
					<label for="${product.name}" class="product <c:if test="${product.selected}">selected</c:if>">
						${product.name} (${product.priceFormatted} &euro;)
					</label>
					</c:forEach>
				</div>
				<div id="panel">
					<div id="coin-hole"></div>
					<div id="hint">&lt;- Drag coins here</div>
				</div>
				<input type="submit" id="submit" value="Confirm"/>
				<div id="display">
					<div id="total">
					<!-- TODO: Probably there's a better way to do this. -->
						Total: <span id="amount">${purchaseForm.amountFormatted}</span>
						<form:hidden id="amountInput" path="amount" value="${purchaseForm.amount}"/>
					</div>
					<div id="message">${message}</div>
				</div>
			
			</form:form>
			
			
			
		</div>
	</div>
	<script src="resources/js/home.js"></script>
</body>
</html>
