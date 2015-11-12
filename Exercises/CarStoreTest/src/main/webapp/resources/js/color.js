$(function() {
	$(".button").button();
	$(".buttons-container").buttonset();

	$(".color-button").on("click", function() {
		loadImage($(this));
	});
});

function loadImage($button) {
	$("#image-container").html(
			"<img src='resources/img/" + $button.data("img") + ".png' />");
}