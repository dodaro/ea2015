<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/resources/style/styleArt.css">
<link rel="stylesheet" type="text/css" href="/resources/script/jquery-ui-1.11.4/jquery-ui.css">
<script src="/resources/script/jquery-ui-1.11.4/external/jquery/jquery.js"></script>
<script src="/resources/script/jquery-ui-1.11.4/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		$("#form :radio:first").prop('checked', true);
		$(".picture").html('<img class="model" src="/resources/models/blueF.jpg" alt="blueCar">');
		 
	});
	
	$(document).ready(function() {
		$("#form").buttonset();
	});
	
	$(document).ready(function() {
		$("#form :radio").click(function() {
			if ($(this).is(':checked')) {
				var ck = $(this).val();
					if (ck == "Blue") {
						$(".picture").html('<img class="model" src="/resources/models/blueF.jpg" alt="blueCar">');
					} 
					else if (ck == "Red") {
						$(".picture").html('<img class="model" src="/resources/models/redF.jpg" alt="redCar">');
					} 
					else if (ck == "Yellow") {
						$(".picture").html('<img class="model" src="/resources/models/yellowF.jpg" alt="yellowCar">');
					}
			}
		});
	});

</script>
</head>

<body>
	<div id="wrapper">
		<div id="header"></div>

		<div id="content">
			<h1>Choose your color!</h1>
			<form:form id="form" method="POST" action="#" commandName="userResponse">
				<form:radiobutton path="colorChoosed" value="Blue" label="Blue (100)"/>
				<form:radiobutton path="colorChoosed" value="Red" label="Red (200)"/>
				<form:radiobutton path="colorChoosed" value="Yellow" label="Yellow (300)"/>		
						
			<p>
				<input type="submit" name="change" value="Next" />
			</p>	
		</form:form>
		<div class="picture"></div>


		</div>
		<div id="footer">Enterprise Applications - Department of
			Mathematics and Computer Science - University of Calabria -
			Arcavacata di Rende (CS) - Italy
		</div>
	</div>
</body>
</html>
