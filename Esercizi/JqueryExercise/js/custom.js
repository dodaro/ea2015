$(function() {
  $("button").button();
  var hideButton = $( "#hideButton" );

  $(".social").button({
      icons: {
        primary: "ui-icon-link"
      },});


  hideButton.click(function() {
  	$("#textToHide").toggleClass( "hidden", 300, "easeOutSine" );
  	var text = $("span",this).text();
  	$("span",this).text( text == "Show Content" ? text = "Hide Content" : "Show Content");
  });

  $("#showButton").click(function(){
  	var src = $("#imgurl").val();
  	var img = document.createElement("img");
  	console.log(src);
  	img.setAttribute("src",src);
  	img.setAttribute("width",$("#pic").width());
  	img.setAttribute("height",$("#pic").height());
  	$("#pic").html(img);
  });


});