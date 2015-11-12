<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="resources/css/common.css" />
<link rel="stylesheet" href="resources/css/summary.css" />

<title>Summary</title>
</head>
<body>
	<div id="container">
		<%@include file="includes/header.html"%>
		<div id="content">
			<table id="summary-table">
				<tr class="highlited">
					<th>Your car</th>
				</tr>
				<tr>
					<td><span class="table-label">Model:</span> ${model}</td>
				</tr>
				<tr>
					<td><span class="table-label">Color:</span> ${color}</td>
				</tr>
				<tr class="highlited">
					<td><span class="table-label">Total price:</span> ${totalPrice}</td>
				</tr>
			</table>
		</div>
		<%@include file="includes/footer.html"%>
	</div>
</body>

</html>