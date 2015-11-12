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
	
	<script type="text/javascript">
	$(document).ready(function()
	{
		$("label").click(function(event)
		{
			console.log(event.target.id);
			$("#imageColor").css("background-color", event.target.id);			
		});
	});
	</script>
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
			<div class="col-md-12">		
					<h3>Choose a color: </h3>		
					<form:form method="POST" commandName="user">
						<div class="btn-group" data-toggle="buttons">
							<c:forEach items="${colorsList}" var="color">
								<label class="btn btn-primary" id="${color.name}">
									<form:radiobutton path="colorSelected" value="${color.name}" label="${color.name}"/>
									(<c:out value="${color.value}" />$) 
								</label>
							</c:forEach>							
						</div>
					<input type="submit" class="btn btn-success" value="SelectColor" />	
					</form:form>		
					
					<div class="padding colorB" id="imageColor">
				
					</div>	
			</div>
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