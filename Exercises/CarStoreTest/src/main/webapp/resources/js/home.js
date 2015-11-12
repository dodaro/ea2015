$(function() {
	$(".button").button();
	$(".buttons-container").buttonset();
	
	$(".model-button").on("click", function() {
		$("#info-container").load("includes/" + $(this).data("infopage") + ".html");
		$("#info-container").accordion();
	});
});