<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="resources/libs/jquery-2.1.4.js"></script>
<script type="text/javascript"
	src="resources/libs/jquery-ui-1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="resources/js/home.js"></script>

<link rel="stylesheet"
	href="resources/libs/jquery-ui-1.11.4/jquery-ui.css" />
<link rel="stylesheet" href="resources/css/common.css" />
<link rel="stylesheet" href="resources/css/home.css" />

<title>Car Store</title>

</head>
<body>
	<div id="container">
		<%@include file="includes/header.html"%>
		<div id="content">
			<div id="form-container">
				<form:form modelAttribute="modelForm" method="post">
					<div class="buttons-container">
						<c:forEach items="${carStore.models}" var="model">
							<form:radiobutton id="${model}" class="model-button button"
								path="model" value="${model}"
								data-infopage="${fn:toLowerCase(model)}" />
							<label for="${model}">${model}
								(${carStore.getModelPrice(model)} &euro;)</label>
						</c:forEach>
					</div>
					<input type="submit" class="button" value="Next" />
				</form:form>
			</div>
			<div id="info-container"></div>
		</div>
		<%@include file="includes/footer.html"%>
	</div>
</body>
</html>
