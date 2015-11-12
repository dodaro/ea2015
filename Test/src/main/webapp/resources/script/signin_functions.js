$(document).ready(function(){
	$( "#checkboxes" ).buttonset();
});

$(document).ready(function(){
	$( "#countries" ).selectmenu();
});


//allows to select on checkbox a time

$(document).ready(function(){	

	$("#checkboxes input[type=checkbox]").click(function(){
		return false;
		/*$("#checkboxes input[type=checkbox]").each(function () {

			$(this).prop("checked", false);
						
		});*/
	});
});		