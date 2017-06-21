jQuery(document).ready(function($) {

    /** Prevents spam-bots from harvesting email address **/

    $('header a.email').on('mouseover.uncensor click.uncensor', function() {
        uncensorEmail($(this));

        // disable this event handler, doesn't need run again
        $(this).off('mouseover.uncensor click.uncensor');
    });
});

function uncensorEmail(element) {
    var href = element.attr('href');
    element.attr('href', href.replace('bad-domain', 'nellyer'));
}