<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<title>VendingMachine</title>
</head>
<body>
<h1>
	Vida chi ti pigli! 
</h1>

	<form:form action="vendingmachine" method="post" commandName="userOrderForm">
		<table>
			<tr>
				<td>
					<form:checkboxes element="li" path="selectedItems" items="${vendingMachineItems.itemsList}" itemValue="price"></form:checkboxes>
				</td> 
			</tr>
			<tr>
				<td>Inserisci importo:</td>
				<td><input type="text" name="amount"></td>
				<td><input type="submit" name="submit" value="send" /></td>
			</tr>
		</table>
		<tr><h3>${message}</h3></tr>
		<h3>Vida chi ti pigli 2.0 - <a href="http://fmaida.it">fmaida.it</a></h3>
	</form:form>

</body>
</html>
