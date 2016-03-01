/*jqueryzoom&&jcarousel*/

(function($) {
	$.fn.jqueryzoom = function(options) {
		var settings = {
			xzoom : 200,
			yzoom : 200,
			offset : 10,
			position : "right",
			lens : 1,
			preload : 1
		};
		if (options) {
			$.extend(settings, options);
		}
		var noalt = '';
		count = 0;
		if (settings.preload) {
			$(this).each(
					function() {
						var imagetopreload = $(this).children("img").attr(
								"jqimg");
						var content = jQuery('div.jqPreload' + count + '')
								.html();
						jQuery('div.jqPreload' + count + '').html(
								content + '<img src=\"' + imagetopreload
										+ '\">');
					});
		}
	}
})(jQuery);
function MouseEvent(e) {
	this.x = e.pageX;
	this.y = e.pageY;
}