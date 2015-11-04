<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Candy shop</title>
</head>
<body>
<h1>
	Candy shop:  
</h1>

<form:form action="candy" method="post" commandName="user">
	<c:forEach items="${candiesList}" var="candy">
		<p> 
			<form:checkbox path="selectedCandies" value="${candy.value}" label="${candy.name}" />
			(<c:out value="${candy.value}" />$) 
		</p>
	</c:forEach>   	
	<p>Money: <form:input path="money" /></p>
	<p> <input type="submit" value="Buy" /> </p>   	          
</form:form>
</body>
</html>