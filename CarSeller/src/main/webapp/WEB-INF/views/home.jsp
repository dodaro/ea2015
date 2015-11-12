<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
  	<link rel="stylesheet" type="text/css" href="resources/script/jquery-ui-1.11.4/jquery-ui.css">
  	<link rel="stylesheet" type="text/css" href="resources/style/style.css">
	<script src="resources/script/jquery-ui-1.11.4/external/jquery/jquery.js"></script>
	<script src="resources/script/jquery-ui-1.11.4/jquery-ui.js"></script>	
	<script>
	
	$(document).ready(function() {
		$("#button").button();
		$("#show").button();
	});
	$(document).ready(function() {
		$("#form").buttonset();
	});
	
	
	</script>
</head>

<body>
<div id="wrapper">
<div id="content">
	<form:form id="form" action="#" method="post" commandName="shopping">
	<table>
	<tr><td>
	<form:checkbox id="se" path="Cars" value="se"/>
	<label for="se">SE(11000.0 euro)</label>
	<form:checkbox id="seal" path="Cars" value="seal"/>
	<label for="seal">SE A/L(12400.0 euro)</label>
	<form:checkbox id="sl" path="Cars" value="sl"/>
	<label for="sl">SL(15000.0 euro)</label>
	</td></tr>
	</table>
	
	
	<div id="accordion">
			<h3>Section 1</h3>
			<div>
					<p>
							Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer
							ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit
							amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut
						odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
					</p>
			</div>
			  <h3>Section 2</h3>
			<div>
					<p>
					Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet
					purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor
					velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In
					suscipit faucibus urna.
					</p>
			</div>
			<h3>Section 3</h3>
			<div>
			<ul>
			<li>List item one</li>
			<li>List item two</li>
			<li>List item three</li>
			</ul>
  			</div>		
  	</div>		
  	<table>
	<tr><td><input id="button" type="submit" name="Next" value="Next" /></td></tr>
	</table>
	</form:form>
	<button id="show">Show</button>
	</div>
	
	<div id="result">
	<p>Load an external page here</p>
	</div>
	
	</div>
		<div id="footer">
		Enterprise Applications - Department of Mathematics and Computer Science - University of Calabria - Arcavacata di Rende (CS) - Italy
		</div>
</body>
</html>
