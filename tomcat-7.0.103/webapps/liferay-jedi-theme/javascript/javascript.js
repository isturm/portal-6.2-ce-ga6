var LiferayJedi = function () {
	var $ = jQuery;
	return {
		init: function() {
			var instance = this;

			instance.handleSearchForm();
			instance.dropDownMenu();
			instance.handleLastChild();
		},

		handleSearchForm: function() {
			var searchForm = $('#banner .search');

			var searchInput = searchForm.find('input[type=image]');
			var searchLink = $('<a class="search-input-link" href="javascript:;"></a>');

			searchLink.click(
				function() {
					$(this).parents('form')[0].submit();
				}
			);

			searchInput.hide();
			searchInput.before(searchLink);
		},

		handleLastChild: function () {
			var instance = this;

			$('#footer ul li:last').addClass('last-child');
		}
	};
}();

jQuery(document).ready(
	function() {
		LiferayJedi.init();
	}
);