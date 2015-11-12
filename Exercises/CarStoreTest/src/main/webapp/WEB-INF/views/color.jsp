<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="resources/libs/jquery-2.1.4.js"></script>
<script type="text/javascript"
	src="resources/libs/jquery-ui-1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="resources/js/color.js"></script>

<link rel="stylesheet"
	href="resources/libs/jquery-ui-1.11.4/jquery-ui.css" />
<link rel="stylesheet" href="resources/css/common.css" />

<title>Choose color</title>

</head>
<body>
	<div id="container">
		<%@include file="includes/header.html"%>
		<div id="content">
			<div id="form-container">
				<form:form modelAttribute="colorForm" method="post">
					<div class="buttons-container">
						<c:forEach items="${carStore.colors}" var="color">
							<form:radiobutton id="${color}" class="color-button button"
								path="color" value="${color}"
								data-img="${fn:toLowerCase(color)}" />
							<label for="${color}">${color} (${carStore.getColorPrice(color)} &euro;)</label>
						</c:forEach>
					</div>
					<input type="submit" class="button" value="Next" />
				</form:form>
			</div>
			<div id="image-container"></div>
		</div>
		<%@include file="includes/footer.html"%>
	</div>
</body>
</html>
