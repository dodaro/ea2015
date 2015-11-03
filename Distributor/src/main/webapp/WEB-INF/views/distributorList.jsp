<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Distributor List</title>
</head>
<body>
	<h1>Distributor List</h1>
	<form:form action="#" method="post" commandName="distributorListAction">
		<h3>Choose products:</h3>
		<fieldset>
			<c:forEach items="${listdistributor.products}" var="singleProduct">
				<input type="checkbox" name="product"
					value="${singleProduct.priceProduct}" /> 
					${singleProduct.nameProduct} : ${singleProduct.priceProduct} 
				<br>
			</c:forEach>
		</fieldset>
		Credits:
		<input type="text" name="credit" placeholder="Insert your credit">
		<p>Message: ${message}</p>
		<input type="submit" name="buyButton" value="buy" />
	</form:form>
</body>
</html>
