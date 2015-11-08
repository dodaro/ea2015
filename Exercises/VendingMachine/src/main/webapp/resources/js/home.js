$(function() {
	// Dealing with integers avoids float rounding errors.
	var amount = parseFloat($("#amountInput").val()) * 100;
	
	$(".product").on("click", function(event) {
		$this = $(this);
		
		if ($this.hasClass("selected")) {
			$(this).removeClass("selected");
		} else {
			$(this).addClass("selected");
		}
	});
	
	$(".coin").draggable({
		revert: true,
		revertDuration: '0'
	});
	
	$("#coin-hole").droppable({
		drop: function(event, ui) {
			insertedAmount = parseInt($(ui.draggable).data("value"));
			amount += insertedAmount;
			$("#amount").html((amount / 100).toFixed(2));
			$("#amountInput").val(amount / 100);
		}
	})
});