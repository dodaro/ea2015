$(function() {
	$("button").button();
	$("#accordion").accordion();
	$( "#radioset" ).buttonset();

	$("input[name='car']").click(function(){
		var choice = this.value;
		alert(choice);
		var path = "<c:url value='/resources/SE.html' />";
		
		$("#content").load(path);

	});
});