$(function() {
  var hideButton = $( "#hideButton" ).button();

  hideButton.click(function() {
  	$("#textToHide").toggleClass( "hidden", 300, "easeOutSine" );
  	$(this).html('<span class="ui-button-text">Show Content</span>');
  });


});