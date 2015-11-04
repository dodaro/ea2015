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
			<tr>
				<td><form:checkbox path="choosenProd" value="1" />Coffe</td>
				<td>1</td>
			</tr>
			<tr>
				<td><form:checkbox path="choosenProd" value="3" /> Tea</td>
				<td>3</td>
			</tr>
			<tr>
				<td><form:checkbox path="choosenProd" value="2" /> Snack</td>
				<td>2</td>

			</tr>
			<tr>
				<td><form:checkbox path="choosenProd" value="3" /> Milk</td>
				<td>3</td>

			</tr>
			<tr>
				<td><form:checkbox path="choosenProd" value="8" /> Sandwich</td>
				<td>8</td>

			</tr>
			<tr>
				<td><form:checkbox path="choosenProd" value="4" /> Chips</td>
				<td>4</td>

			</tr>
			<tr>
				<td><form:checkbox path="choosenProd" value="3" /> Chewingum</td>
				<td>3</td>

			</tr>
			<tr>
				<td><form:checkbox path="choosenProd" value="1" /> Water</td>
				<td>1</td>

			</tr>
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
				<td><label>${message }</label></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
