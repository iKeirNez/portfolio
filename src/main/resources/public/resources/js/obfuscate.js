jQuery(document).ready(function($) {

    /** Prevents spam-bots from harvesting email address **/

    $('a[data-obfuscate]').on('mouseover.uncensor click.uncensor', function() {
        deobfuscateEmail($(this).data('obfuscate'), $(this));

        // disable this event handler, doesn't need run again
        $(this).off('mouseover.uncensor click.uncensor');
    });
});

function deobfuscateEmail(encodedEmail, element) {
    var decodedEmail = atob(encodedEmail);
    element.attr('href', "mailto:" + decodedEmail);
}