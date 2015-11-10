<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<script src="<c:url value='/resources/script/jquery-ui-1.11.4/external/jquery/jquery.js' />"></script>
	<title>Dispenser</title>
		
</head>
<body>

<form:form action="#" method="POST" commandName="dispenserAction">
	<table>
	<c:forEach items="${dispenserAction.list}" var="product" varStatus="i">
		<tr>
			<td>
				<form:checkbox path="idSelect" value="${i.count}" />
				<label>${product.name} : ${product.price} Euro </label>
				<!--<form:input  path="list[${i.index}].price" />-->
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td><input type="text" name="money"/></td>
		<td><input type="submit"/></td>
		<td>Missing: ${missing}</td>
		<td>Inserted: <div id="inserted">${inserted}</div> </td>
	</tr>
	</table>
	
<!-- questo è un modo per rimapparmi prezzi e nomi in quanto ancora non abbiamo visto come lavora il binding di un oggetto-->	
	
	
	
	<form:input type="hidden" path="moneyOnMachine"/>
</form:form>
</body>
</html>
