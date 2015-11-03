<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Distributor</title>
</head>
<body>
	<h1>Distributor</h1>
	<form:form action="#" method="post" commandName="distributorAction">
		<h3>Choose products:</h3>
		<fieldset>
			<input type="checkbox" name="product1" value="${mydistributor.priceProduct1}" /> 
			${mydistributor.nameProduct1} : ${mydistributor.priceProduct1} 
			<br> 
			
			<input type="checkbox" name="product2" value="${mydistributor.priceProduct2}" />
			${mydistributor.nameProduct2} : ${mydistributor.priceProduct2} 
			<br>
			
			<input type="checkbox" name="product3" value="${mydistributor.priceProduct3}" /> 
			${mydistributor.nameProduct3} : ${mydistributor.priceProduct3} 
			<br> 
			
			<input type="checkbox" name="product4" value="${mydistributor.priceProduct4}" />
			${mydistributor.nameProduct4} : ${mydistributor.priceProduct4} 
			<br>
		</fieldset>
		Credits:
		<input type="text" name="credit" placeholder="Insert your credit">
		<p>Message: ${message}</p>
		<input type="submit" name="buyButton" value="buy" />
	</form:form>
</body>
</html>
