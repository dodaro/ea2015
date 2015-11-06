<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/default.css' />">
<link rel="stylesheet" type="text/css"
	href="resources/script/jquery-ui-1.11.4.dark2/jquery-ui.css">
<script
	src="resources/script/jquery-ui-1.11.4.dark2/external/jquery/jquery.js"></script>
<script src="resources/script/jquery-ui-1.11.4.dark2/jquery-ui.js"></script>
<script src="resources/script/functions.js"></script>

</head>
<body>
	<!-- contains all the other div -->
	<div class="container">
		<!-- these .external div are the four gray blocks -->
		<div class="external">

			<!-- each gray block contains an internal div which contains all the elements -->
			<div id="div1" class=internal>
				<div>you can use this div to store some information</div>
				<div>
					<button id="hide" class="button">Click to Hide this div1</button>
				</div>
			</div>
		</div>
		<div class="external">
			<div class=internal>
				<div>Social Networks:</div>
				<div>
					<button id="Facebook" class="button">Facebook</button>
					<button id="Twitter" class="button">Twitter</button>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="external">
			<div class=internal>
				<div>Add link to an image (available: image1, image2)</div>
				<div>
					<input type="text" id="input" /> <input type="submit"
						class="button" value="Submit" id="submit">
				</div>
			</div>
		</div>
		<div class="external">
			<div class=internal id="div3">
				<div>This div will contain the image loaded by div3</div>
			</div>
		</div>
	</div>
</body>
</html>
