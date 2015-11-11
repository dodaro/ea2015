<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<title>DealerMachine</title>
</head>
<body>
	<h1>DEALER MACHINE</h1>


	<form:form modelAttribute="machine" method="post"
		commandName="dealerForm">
		<table>
			<c:forEach items="${machine.getProducts()}" var="current" varStatus="status">
				<tr>
					<td><form:checkbox path="choosenProd" value="${current.getPrice()}" />${current.getName()}</td>
					<td>${current.getPrice()}</td>
				</tr>
			</c:forEach>
			<tr></tr>
			<tr>
				<td>Insert Money:</td>
				<td><form:input path="money" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Purchase"></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td><label>${message}</label></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
