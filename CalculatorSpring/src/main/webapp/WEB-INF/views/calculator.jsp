<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<html>
<head>
	<title>Calculator</title>
</head>
<body>
<h1>
	Calculator  
</h1>
	<form:form action="#" method="post" commandName="calculatorAction">
	<table>
	<tr>
		<td><form:input path="number1" /></td>
		<td><form:input path="number2" /></td>
		<td>Result: ${result}</td>		
	</tr>
	</table>
	<table>
	<tr>
		<td><input type="submit" name="calc" value="+" /></td>
		<td><input type="submit" name="calc" value="-" /></td>
	</tr>
	<tr>
		<td><input type="submit" name="calc" value="*" /></td>
		<td><input type="submit" name="calc" value="/" /></td>
	</tr>
	</table>
	</form:form>
</body>
</html>
