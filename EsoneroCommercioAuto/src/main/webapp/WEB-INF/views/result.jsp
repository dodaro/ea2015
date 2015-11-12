<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page session="false" %>
<html>
<head>

	<link href="<c:url value='./resources/script/jquery-ui-1.11.4/jquery-ui.css' />" rel="stylesheet">
	<link href="<c:url value='./resources/style/style.css' />" rel="stylesheet">
    <script src="<c:url value='./resources/script/jquery-ui-1.11.4/external/jquery/jquery.js' />"></script>
	<script src="<c:url value='./resources/script/jquery-ui-1.11.4/jquery-ui.js' />"></script>
	
	
	

</head>
<body>
	
	<div id="wrapper">
  		<div id="header">
		</div>

		<div id="content">
			<div id="description">
				<table>
					<tr>
						<td>Car name:</td><td>${ resultAction.cars[(resultAction.idSelect)-1].name}</td>
					</tr>
					<tr>
						<td>Color:</td><td>${ resultAction.cars[(resultAction.idSelect)-1].availableColor[(resultAction.colorSelect)-1]}</td>
					</tr>
					<tr>
						<td>Price:</td><td>${ resultAction.cars[(resultAction.idSelect)-1].price}</td>
					</tr>
				</table>
				
			</div>
			
		</div>
	
		<div id="footer">
		Enterprise Applications - Department of Mathematics and Computer Science - University of Calabria - Arcavacata di Rende (CS) - Italy
		</div>
	</div>
</body>
</html>
