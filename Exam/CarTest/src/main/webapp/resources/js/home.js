

$(document).ready(function() {
	
	
	$("#carList").buttonset();
	$(".nextButton").button();
	
	addListeners();
	
});



function addListeners() {
	
	$("#carList input").each(function(index, elem){
		
		$(elem).on("click", function(){
			
			loadAccordion($(elem).attr('id'));
		});
	});
	
}


function loadAccordion(carName) {
	
	
	var text = $("#" + carName).siblings("label").find("span").text();
	var result = text.substr(0, text.indexOf(' '));	
	result = result.toLowerCase();
	
	$.get("/resources/accordContent/"+ result +".html", function( data ) {
		  
		$("#accordionContent").html(data);
		$(".description").accordion();
	});
}
