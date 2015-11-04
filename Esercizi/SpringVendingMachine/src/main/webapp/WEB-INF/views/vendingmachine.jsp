<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<title>VendingMachine</title>
</head>
<body>
<h1>
	Vida chi ti pigli! 
</h1>

	<form:form action="vendingmachine" method="post" commandName="vendingMachineForm">
		<table>
			<tr>
				<td>${vendingMachineForm.coffeeItem.name}</td>
				<td>${vendingMachineForm.coffeeItem.price}</td>
        		<td><input type="checkbox" name="${vendingMachineForm.coffeeItem.name}" value="${vendingMachineForm.coffeeItem.price}"></td>  
			</tr>
			<tr>
				<td>${vendingMachineForm.waterItem.name}</td>
				<td>${vendingMachineForm.waterItem.price}</td>
        		<td><input type="checkbox" name="${vendingMachineForm.waterItem.name}" value="${vendingMachineForm.waterItem.price}"></td>  
			</tr>
			<tr>
				<td>${vendingMachineForm.teaItem.name}</td>
				<td>${vendingMachineForm.teaItem.price}</td>
        		<td><input type="checkbox" name="${vendingMachineForm.teaItem.name}" value="${vendingMachineForm.teaItem.price}"></td>  
			</tr>
			<tr>
				<td>${vendingMachineForm.juiceItem.name}</td>
				<td>${vendingMachineForm.juiceItem.price}</td>
        		<td><input type="checkbox" name="${vendingMachineForm.juiceItem.name}" value="${vendingMachineForm.juiceItem.price}"></td>  
			</tr>
			<tr>
				<td>${vendingMachineForm.vodkaItem.name}</td>
				<td>${vendingMachineForm.vodkaItem.price}</td>
        		<td><input type="checkbox" name="${vendingMachineForm.vodkaItem.name}" value="${vendingMachineForm.vodkaItem.price}"></td>  
			</tr>
			<tr>
				<td>${vendingMachineForm.beerItem.name}</td>
				<td>${vendingMachineForm.beerItem.price}</td>
        		<td><input type="checkbox" name="${vendingMachineForm.beerItem.name}" value="${vendingMachineForm.beerItem.price}"></td>  
			</tr>
			<tr>
				<td>Inserisci importo:</td>
				<td><input type="text" name="amount"></td>
				<td><input type="submit" name="submit" value="send" /></td>
			</tr>
			
		</table>
		<tr><h3>${message}</h3></tr>
		<h3>Vida chi ti pigli 1.0 - <a href="http://fmaida.it">fmaida.it</></h3>
	</form:form>

</body>
</html>
