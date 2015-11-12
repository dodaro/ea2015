<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<html>
<head>
	<title>Car site home</title>

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
			var info1 = $("#" + event.target.id + "Info1").val();
			var info2 = $("#" + event.target.id + "Info2").val();
			var info3 = $("#" + event.target.id + "Info3").val();
			console.log(info1 + " " + info2 + " " + info3);
			
			$('.collapse').collapse()
			
			$("#body1").html(info1);
			$("#body2").html(info2);
			$("#body3").html(info3);
		});
	});
	</script>
</head>
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
		        	<li class="active"><a href="/">Home</a></li>
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
				<h3>Choose a car: </h3>		
				<form:form method="POST" commandName="user">
					<div class="btn-group" data-toggle="buttons">
						<c:forEach items="${carsList}" var="car">
							<label class="btn btn-primary" id="${car.model}">
								<c:out value="${car.brand}" />
								<form:radiobutton path="carSelected" value="${car.model}" label="${car.model}"/>
								(<c:out value="${car.value}" />$) 
							</label>
							<input hidden="true" type="text" id="<c:out value="${car.model}" />Info1" value="${car.info1}"/>
							<input hidden="true" type="text" id="<c:out value="${car.model}" />Info2" value="${car.info2}"/>
							<input hidden="true" type="text" id="<c:out value="${car.model}" />Info3" value="${car.info3}"/>
						</c:forEach>					
					</div>
					<input type="submit" class="btn btn-success" value="SelectCar" />
				</form:form>
			</div>
		</div>
		<div class="row" id="informations">
		
		<div class="panel-group collapse" id="accordion" role="tablist" aria-multiselectable="true">
		  <div class="panel panel-default">
		    <div class="panel-heading" role="tab" id="headingOne">
		      <h4 class="panel-title">
		        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
		         Info 1
		        </a>
		      </h4>
		    </div>
		    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
		      <div class="panel-body" id="body1">
		        
		      </div>
		    </div>
		  </div>
		  <div class="panel panel-default">
		    <div class="panel-heading" role="tab" id="headingTwo">
		      <h4 class="panel-title">
		        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
		          Info 2
		        </a>
		      </h4>
		    </div>
		    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
		      <div class="panel-body" id="body2">
		        
		      </div>
		    </div>
		  </div>
		  <div class="panel panel-default">
		    <div class="panel-heading" role="tab" id="headingThree">
		      <h4 class="panel-title">
		        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
		          Info 3
		        </a>
		      </h4>
		    </div>
		    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
		      <div class="panel-body" id="body3">
		       
		      </div>
		    </div>
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
