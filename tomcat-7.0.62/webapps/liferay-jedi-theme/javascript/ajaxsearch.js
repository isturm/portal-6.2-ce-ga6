var loading;
$(function() {
	var tags = [ "" ],
		lastTerm = "",
		minlength = 3;
		
	loading = false;
	$suche = $("#suche");
	$input = $("#suche input");
	$social = $("#social");

	// do ajax search on changed search term and minlength
	$input.keypress(function(event) { setTimeout(function (){ 
			var searchTerm = $input.val().trim();
			console.log(searchTerm.length);
			
			if (event.which == 37 || event.which == 39 || event.which == 38 || event.which == 40) { // arrow key pressed
				event.stopPropagation();
				
				$suche.find("li.focus").removeClass("focus");
				if ($input.val() != null){
					$suche.find("li a.ui-state-focus").parent().addClass("focus");
				}			
			
			}else 
				if (event.which == 13 ) {
				event.stopPropagation();
			}else{
				if (searchTerm !== lastTerm && searchTerm.length >= minlength) {
					loading = true;
					console.log("Last: '" + lastTerm + "'");
					console.log("This: '" + searchTerm + "'");
					AutocompleteManager.getAutocompleteResults(searchTerm,
							handleAutocompleteResultChange);
					lastTerm = searchTerm;
				}
				if (searchTerm.length < minlength) {$input.autocomplete("close"); lastTerm = searchTerm}
			}
	 	}, 1);
	}).on('keydown', function(event) {
		   if (event.keyCode==8)
			    $input.trigger('keypress');
			 });
	
	// initialize autocomplete
	$input.autocomplete({
		source : tags,
		minLength : minlength,
		delay: 1000000,
		appendTo: "#suche",
		select: function(event, ui) {
            $input.val(ui.item.value);
			$suche.find("form").submit();
		},
		focus: function(event, ui) {
			$input.val(ui.item.value);
			if (loading) {
				if (event.which == 37 || event.which == 38 || event.which == 39 || event.which == 40) {
					$suche.find("li.focus").removeClass("focus");
					event.preventDefault();
				}
			}
			else {
				$suche.find("li.focus").removeClass("focus");
				if (ui.item.value != null){
					$suche.find("li a.ui-state-focus").parent().addClass("focus");
				}
			}
		}
	})
	// mark up search term in results
	.data("ui-autocomplete")._renderItem = function(ul, item) {
		var temp = item.label;
		// find search term case insensitive
		var termLength = lastTerm.length;
		var termBegin = temp.toLowerCase().indexOf(lastTerm.toLowerCase());
		var termEnd = termBegin + termLength;
		
		var markedResult = temp.slice(0, termBegin)
			+ "<span class='marked'>"
			+ temp.slice(termBegin, termEnd)
			+ "</span>"
			+ temp.slice (termEnd, temp.length);
		
		var $a = $("<a></a>").append(markedResult);
		return $("<li></li>").append($a).appendTo(ul);
	};

	// Reflect mouse over items of autocomplete list
	$("#suche").on("mouseover", "ul.ui-autocomplete li", function () {
		$suche.find("li.focus").removeClass("focus");
		$(this).addClass("focus");
	}).on("mouseout", "ul.ui-autocomplete li", function () {
		$(this).removeClass("focus");
	});
});

// show autocomplete results 
function handleAutocompleteResultChange(data) {
	$input.autocomplete("option", "source", data).autocomplete("search", $input.val().trim());
	loading = false;
	console.log("Result: " + data);
}
