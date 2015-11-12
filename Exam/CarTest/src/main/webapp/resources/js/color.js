

$(document).ready(function() {
	
	
	$("#colorList").buttonset();
	$(".nextButton").button();
	
	addListeners();
	
});



function addListeners() {
	
	$("#colorList input").each(function(index, elem){
		
		$(elem).on("click", function(){
			
			loadAccordion($(elem).attr('id'));
		});
	});
	
}


function loadAccordion(colorName) {
	
	
	var text = $("#" + colorName).siblings("label").find("span").text();
	var result = text.substr(0, text.indexOf(' '));	
	result = result.toLowerCase();
	
	
	var content = "<img class='preview' src='/resources/imgs/"+ result +".jpg'></img>";
	$("#imgContent").html(content);
	
}
