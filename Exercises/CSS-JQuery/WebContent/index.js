$(function() {
	initButtons();

});

function initButtons() {
	$(".js-button-hide").on("click", function() {
		hideDiv1();
	});

	$(".js-button-link").on("click", function() {
		window.location = $(this).data("url");
	});

	$(".js-button-load-image").on("click", function() {
		loadImage();
	});
}

function hideDiv1() {
	$("#div1").hide();
}

function loadImage() {
	var link = $(".js-image-url").val();
	$("#image-container").append("<img src='" + link + "' />");
}