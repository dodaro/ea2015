

$(document).ready(function(){
	
	manager = new Manager();
	manager.initContainers();
});



var Manager = (function() {
	
	function Manager() {
		
		var alreadyInitialized = false;
		
		var initLabels = function() {
			
			$(".container").each(function(index, elem) {
				var title = $(elem).data("label");
				$(elem).find(".containerTitle").append(title + "!");
			});
		};
		
		var initButtons = function() {
			
			$(".button").each(function(index, elem) {
				$(elem).button();
			});
		};

		
		var initSection1 = function() {
			
			var container = $("#nwContainer");
			var title = container.data("label");
			var button = container.find(".button");
			
			var container2 = $("#nwContainer2");
			var toggleButton = $("#toggleButton");
			
			button.append(" " + title);
			button.on("click", function() {
			
				$.when(container.fadeOut()).done(function(){
					
					container2.fadeIn();
				});
			});
			
			
			container2.hide();
			toggleButton.on("click", function(){
			
				container2.toggle();
				container.toggle();
			});
			toggleButton.button();
		};
		
		
		var initSection2 = function() {
			
			$("#neContainer").find(".link").each(function(index, elem){
				
				elem = $(elem);
				var url = elem.data("url");
				var text = elem.text();
				elem.html("<a href='" + url + "'>" + text + "</a>");
			});
		};
		
		
		var initSection3 = function() {
		
			var imgUrl = 'http://quib.ly/media/admin_upload/Homer_simpsonwoohooo.gif';
			$("#imageUrlInput").val(imgUrl);
			
			var container = $("#swContainer");
			container.find(".button").on("click", function(){
				
				var imgUrl = $("#imageUrlInput").val();
				
				$("#seContainer").html('<img class="imgContainer" src="'+ imgUrl +'" />');
			});
		};
		
		
		var initSection4 = function() {
			
			var text = $("#swContainer").data('label');
			$("#seContainer").find("p").append(" " + text);
		}
		
		
		this.initContainers = function() {

			if(alreadyInitialized === false) {
			
				alreadyInitialized = true;
				
				initLabels();
				
				initSection1();
				initSection2();
				initSection3();
				initSection4();
				
				initButtons();
			}
			else {
				
				console.log("Operation not permitted!! Init function can be called one time.");
			}
			
		};
		
	}
	
	return Manager;
})();