<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<script src="<c:url value='/resources/script/jquery-ui-1.11.4/external/jquery/jquery.js' />"></script>
	<title>Dispenser</title>
		
	<script>
	$(document).ready(function() {
		
		var price=$("#inserted").text();
		if(price!==0.0 && price!==""){
			var id=$("#idSel").val();
			if(id==1){
				$("#two").prop("disabled",true);
				$("#three").prop("disabled",true);
				$("#one").attr('checked', true);
			}
			else if(id==2){
				$("#one").prop("disabled",true);
				$("#three").prop("disabled",true);
				$("#two").attr('checked', true);
			}
			else if(id==3){
				$("#two").prop("disabled",true);
				$("#onw").prop("disabled",true);
				$("#three").attr('checked', true);
			}
		}
		
	}); 
	</script>
</head>
<body>



<!-- 

AGGIUNGERE JQUERY, ED INSERIRE NELLA FUNZIONE READY il check sull'id "importante"
se idSelect è diverso da 0 allora vanno bloccati i tasti

 -->
<form:form action="#" method="POST" commandName="dispenserAction">
	<table>
	<tr>
		<td><input type="radio" name="product" id="one" value=1 />${ dispenserAction.p1.name } : ${ dispenserAction.p1.price } Euro</td>
	</tr>
	<tr>
		<td><input type="radio" name="product" id="two" value=2 />${ dispenserAction.p2.name } : ${ dispenserAction.p2.price } Euro</td>	
	</tr>
	<tr>
		<td><input type="radio" name="product" id="three" value=3 />${ dispenserAction.p3.name } : ${ dispenserAction.p3.price } Euro</td>
		
	</tr>
	<tr>
		<td><input type="text" name="money"/></td>
		<td>Missing: ${missing}</td>
		<td>Inserted: <div id="inserted">${inserted}</div> </td>
	</tr>
	</table>
	
<!-- questo è un modo per rimapparmi prezzi e nomi in quanto ancora non abbiamo visto come lavora il binding di un oggetto-->	
	
	<form:input type="hidden" path="p1.price" />
	<form:input type="hidden" path="p2.price" />
	<form:input type="hidden" path="p3.price" />
	
	<form:input type="hidden" path="p1.name" />
	<form:input type="hidden" path="p2.name" />
	<form:input type="hidden" path="p3.name" />
	
	<form:input type="hidden" path="moneyOnMachine"/>
	<form:input type="hidden" id="idSel" path="idSelect"/>
</form:form>
</body>
</html>
