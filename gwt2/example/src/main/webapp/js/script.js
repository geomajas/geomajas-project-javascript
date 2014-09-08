/*
			  ~ This is part of Geomajas, a GIS framework, http://www.geomajas.org/.
			  ~
			  ~ Copyright 2008-2014 Geosparc nv, http://www.geosparc.com/, Belgium.
			  ~
			  ~ The program is available in open source according to the GNU Affero
			  ~ General Public License. All contributions in this program are covered
			  ~ by the Geomajas Contributors License Agreement. For full licensing
			  ~ details, see LICENSE.txt in the project root.
			  */

// load when the document is ready.
$(document).ready(function() {

	var $container = $('#masonry');

	$container.isotope({
		itemSelector : '.masonry_item'
	});

	// quick search regex
	var qsRegex;

	// use value of search field to filter
	var $search = $('#search').keyup(function() {

		// Reset the active class to all items.
		$('.filter li').removeClass('active');
		$('#filterAll').addClass('active');

		$container.isotope({
			itemSelector: '.masonry_item',
			filter: function() {
				return qsRegex ? $(this).text().match( qsRegex ) : true;
			}
		});

		qsRegex = new RegExp( $search.val(), 'gi' );
		$container.isotope();

	});


	// Show every item when the X is clicked in the search input form.
	$('input[type=search]').on('search', function () {

		$container.isotope({
			itemSelector: '.masonry_item',
			filter: "*"
		});

		return(false);

	});

	// Filter isotope entries.
	$('.filter li').click(function(){

		$container.isotope({
			itemSelector: '.masonry_item',
			filter: "*"
		});

		$('.filter li').removeClass('active');
		$(this).addClass('active');

		var selector = $(this).find('a').attr('data-option-value');
		$container.isotope({ filter: selector });

		return(false);

	});

	// Open the example on click
	$('.entry').each(function() {

		$(this).click(function() {

			var href = $(this).find('a').attr('href');
			window.open(href, '_blank');

		});

	});

	// Ignore clicking on the sample link so we don't open the sample twice.
	$('.entryLink').click(function(e) {
		e.stopImmediatePropagation();
	});

});
