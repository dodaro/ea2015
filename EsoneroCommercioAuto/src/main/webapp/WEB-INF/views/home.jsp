<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page session="false" %>
<html>
<head>

	<link href="<c:url value='./resources/script/jquery-ui-1.11.4/jquery-ui.css' />" rel="stylesheet">
	<link href="<c:url value='./resources/style/style.css' />" rel="stylesheet">
    <script src="<c:url value='./resources/script/jquery-ui-1.11.4/external/jquery/jquery.js' />"></script>
	<script src="<c:url value='./resources/script/jquery-ui-1.11.4/jquery-ui.js' />"></script>
	
	
	
	<script>
	
	
	
	$(document).ready(function(){
		$( "#carDescription1" ).accordion();
		$( "#carDescription2" ).accordion();
		$( "#carDescription3" ).accordion();
		$( "#next" ).button();
		$( "#radioset" ).buttonset();
	    $( "#menu button" ).button();
	});
	
	 $(document).ready(function(){
		 $("#radio1").click(function(){
			 	$("#description div").remove();
		        $("#description").append("<div id=\"carDescription1\">"+
		        		"<h3>First</h3>"+
						"<div>Lorem.</div>"+
						"<h3>Second</h3>"+
						"<div>Phasellus.</div>"+
						"<h3>Third</h3>"+
						"<div>Iulium.</div>"+
					"</div>");
		        $( "#carDescription1" ).accordion();
		    });
		 $("#radio2").click(function(){
				$("#description div").remove();
				$("#description").append("<div id=\"carDescription2\">"+
			        		"<h3>First</h3>"+
							"<div>Amet.</div>"+
							"<h3>Second</h3>"+
							"<div>Mattis</div>"+
							"<h3>Third</h3>"+
							"<div>David.</div>"+
						"</div>");
			     $( "#carDescription2" ).accordion();
		    });
		 $("#radio3").click(function(){
			 	$("#description div").remove();
			 	$("#description").append("<div id=\"carDescription3\">"+
			        		"<h3>First</h3>"+
							"<div>Dolor</div>"+
							"<h3>Second</h3>"+
							"<div>Nibh.</div>"+
							"<h3>Third </h3>"+
							"<div>Color.</div>"+
						"</div>");
			    $( "#carDescription3" ).accordion();
		    });
		});
	
   
	
    </script>
</head>
<body>
	
	<div id="wrapper">
  		<div id="header">
		</div>

		<div id="content">
		
			
			<form:form action="#" method="POST" commandName="sellerAction" style="margin-top: 1em;">
				<input type="submit" id="next" value="next"/>
				<div id="radioset">
					<c:forEach items="${sellerAction.cars}" var="car" varStatus="i">
							<form:radiobutton id="radio${i.count}" name="radio${i.count}" path="idSelect" value="${i.count}" /><label for="radio${i.count}">${ sellerAction.cars[(i.count)-1].name} - ${ sellerAction.cars[(i.count)-1].price} EURO</label>
					</c:forEach>
				</div>
				<div id="description"></div>
			</form:form>	
			
		</div>
	
		<div id="footer">
		Enterprise Applications - Department of Mathematics and Computer Science - University of Calabria - Arcavacata di Rende (CS) - Italy
		</div>
	</div>
</body>
</html>
