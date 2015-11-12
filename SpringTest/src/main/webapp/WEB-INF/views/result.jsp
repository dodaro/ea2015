<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<html>
<head>
	<title>Choose color</title>

	<script src="<c:url value='/resources/jquery/jquery.js' />"></script>
	<script src="<c:url value='/resources/bootstrap-3.3.5-dist/js/bootstrap.js' />"></script>	
	<link rel="stylesheet" type="text/css" href="/resources/bootstrap-3.3.5-dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="/resources/style/style.css">
</head>
<body>
	<body>
	<nav class="navbar navbar-default navbar-static-top">
  		<div class="container">
  			<div class="navbar-header">
  				<a class="navbar-brand" href="/">  					
  					<img src="/resources/images/logo_small.png" widht="30px" height="30px"/>
  				</a>
  			</div>
  			<div>
		      	<ul class="nav navbar-nav navbar-right">
		        	<li><a href="/">Home</a></li>
		        	<li><a href="#">Contatti</a></li>
		      	</ul>
		    </div>
  		</div>
	</nav>
	<div class="container">
		<div class="row">
			<img class="image" src="/resources/images/logo.jpg" />
		</div>
		<div class="row padding">	
		<p align="center">
			<h3>Result:</h3>
			<table>		
				<tr>
					<td class="title">${user.carSelected}</td><td>${carValue}</td>
				</tr>
				<tr>
					<td class="title">${user.colorSelected}</td> <td>${colorValue}</td>
				</tr>
				<tr>
					<td class="title">Totale: </td> <td>${total}</td>
				</tr>				 
			</table>
		</p>
		</div>
	</div>
	<nav class="navbar navbar-default navbar-static-bottom">
  		<div class="container">
  			<p align="center">All rights reserved.</p>
  			<p align="center">www.buyyourcar.com</p>
  		</div>
	</nav>
</body>
</html>