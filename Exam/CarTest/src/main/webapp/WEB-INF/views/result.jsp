<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Car seller</title>
	<link rel="stylesheet" type="text/css" href="resources/styles/home.css"/>
	<link rel="stylesheet" type="text/css" href="resources/lib/jquery-ui.min.css"/>
	<script type="text/javascript" src="resources/lib/jquery.min.js"></script>
	<script type="text/javascript" src="resources/lib/jquery-ui.min.js"></script>
	<script type="text/javascript" src="resources/js/home.js"></script>
</head>
<body>


	<div class="container">
	
		<div class="header">
		
		
		</div>
	
		<div class="content">

			<div id="tableContent">
				<table id="resultTable" border="1px"">
					<tr>
						<td id="cart">Your car</td>
					<tr>
					<tr>
						<td>Model: <c:out value="${bill.carName}"></c:out></td>
					<tr>
					<tr>
						<td>Color: <c:out value="${bill.color}"></c:out></td>
					<tr>
					<tr>
						<td id="price">Total price: <c:out value="${bill.amount}"></c:out></td>
					<tr>
				
				</table>
			</div>


		</div>
	
	
		<div class="footer">
			Enterprise application - Department of ....
		</div>
	
	</div>



</body>
</html>
