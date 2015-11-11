$(function() {
	$(".cart-button").on("click", function() {
		var $button = $(this);
		var itemId = $button.parents(".item").data("id");
		var quantity = $button.siblings(".cart-quantity").val();
		addToCart($button, itemId, quantity);
	});
});

/* I get the button as an argument since it must be changed when the response arrives. */
function addToCart($button, itemId, quantity) {
	$.ajax({
		type: "post",
		url: "addToCart",
		data: {
			itemId: itemId,
			quantity: quantity
		},
		dataType: "json",
		success: function(data) {
			console.log(data);
			if (data.success == true) {
				console.log(data.itemId);
				console.log(data.quantity);
				$button.attr("disabled", "disabled");
			}
		}
	});
}