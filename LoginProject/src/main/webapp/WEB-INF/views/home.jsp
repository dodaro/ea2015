<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello World!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<form:checkbox id="coffee" path="products" value="Coffee"/>
	<label for="coffee">Coffee (1 euro)</label>
	<form:checkbox id="milk" path="products" value="Milk"/>
	<label for="milk">Milk (2 euro)</label></body>
</html>
