//preliminar operations
$(document).ready(function(){

	$( ".button" ).button();
	$(".button").css('font-weight','bold');

	//defines a list of available images to load in div3
	$(function() {
		var availableTags = ["image1","image2"];
		$( "#input" ).autocomplete({
			source: availableTags
		});
	});
	
	$( ".internal" ).each(function( index ) {
		 $(this).prepend('<h1>This is the div' + (index+1) + '!');
	});

});

//hides div1
$(document).ready(function(){

	$("#hide").click(function(){
		$("#div1").hide();
	});
});	

//FaceBook and twitter links
$(document).ready(function(){

	$("#Facebook").click(function(){

		window.open("http://www.facebook.it", 'Facebook');
	});

	$("#Twitter").click(function(){

		window.open("http://www.twitter.com", 'Twitter');
	});
});


//displays the images
$(document).ready(function(){

	$("#submit").click(function(){
		
		var val = $("#input").val();
		if(val == "")
			return;
		
		$("#div3").empty();
		$("#div3").append('<img src="/resources/images/' + val + '.jpg" alt="image"/>');
	});
});	


