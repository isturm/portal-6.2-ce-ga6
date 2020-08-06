AUI().use('autocomplete-list','aui-base','aui-io-request','autocomplete-filters','autocomplete-highlighters',
		function (A) {
			var loc = window.location.href;
		    if (loc.match(/lecture/)){
		    	alert ("redirect");
		    };
		}
);