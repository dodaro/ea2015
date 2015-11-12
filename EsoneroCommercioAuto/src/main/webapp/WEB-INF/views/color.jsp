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
			 	$("#description img").remove();
		        $("#description").append("<img src=\"<c:url value='./resources/image/blu.jpg' />\" style=\"width:304px;height:228px;\">");
		        $( "#carDescription1" ).accordion();
		    });
		 $("#radio2").click(function(){
				$("#description img").remove();
				$("#description").append("<img src=\"<c:url value='./resources/image/red.jpg' />\" style=\"width:304px;height:228px;\">");
			    $( "#carDescription2" ).accordion();
		    });
		 $("#radio3").click(function(){
			 	$("#description img").remove();
			 	 $("#description").append("<img src=\"<c:url value='./resources/image/green.jpg' />\" style=\"width:304px;height:228px;\">");
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
	
				
			<form:form action="#" method="POST" commandName="colorAction" style="margin-top: 1em;">
				<input type="submit" id="next" value="next"/>
				<div id="radioset">
					<c:forEach items="${colorAction.cars[(colorAction.idSelect)-1].availableColor}" var="car" varStatus="i">
							<form:radiobutton id="radio${i.count}" name="radio${i.count}" path="colorSelect" value="${i.count}" /><label for="radio${i.count}">${colorAction.cars[(colorAction.idSelect)-1].availableColor[(i.count)-1]}</label>
					</c:forEach>
				</div>
			</form:form>	
			
			<div id="description">
			</div>
			
		</div>
	
		<div id="footer">
		Enterprise Applications - Department of Mathematics and Computer Science - University of Calabria - Arcavacata di Rende (CS) - Italy
		</div>
	</div>
</body>
</html>
