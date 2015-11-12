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
	<script type="text/javascript" src="resources/js/color.js"></script>
</head>
<body>


	<div class="container">
	
		<div class="header">
		
		
		</div>
	
		<div class="content">

			<form:form action="result" method="post" commandName="selection">
			
				<div id="colorList">
					<form:radiobuttons path="idSelected" items="${colors}" itemValue="id" />
				</div>
				
				<div>
					<input class="nextButton" type="submit" value="Next"/>
				</div>
			</form:form>


			<div id="imgContent">
			
			</div>

		</div>
	
	
		<div class="footer">
			Enterprise application - Department of ....
		</div>
	
	</div>



</body>
</html>
