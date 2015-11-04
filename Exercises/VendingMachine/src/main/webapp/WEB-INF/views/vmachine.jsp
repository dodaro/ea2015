<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<html>
<head>
	<title>Vendor Machine Home</title>
</head>
<body>
<h1>
	Vendor Machine Home  
</h1>


<form:form method="POST" commandName="machine">

	<div>
		<form:checkboxes items="${items}" itemValue="price" path="purchase" element="li"/>
	</div>
	
	
	<p>
		money:
		<form:input path="money"/>
	</p>
	
	<p><input type="submit" value="buy" /></p>
	
</form:form>


<p>${message}</p>

</body>
</html>