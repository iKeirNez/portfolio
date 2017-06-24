jQuery(document).ready(function($) {
    /** Prevents spam-bots from harvesting email address **/

    $('a[data-obfuscate]').on('mouseover.uncensor click.uncensor', function() {
        var decoded = xorString($(this).data('obfuscate'), $(this));
        $(this).attr('href', "mailto:" + decoded);

        // disable this event handler, doesn't need run again
        $(this).off('mouseover.uncensor click.uncensor');
    });
});

function xorString(encodedEmail) {
    var decodedEmail = '';

    for (var i = 0; i < encodedEmail.length; i++) {
        decodedEmail += String.fromCharCode(encodedEmail.charCodeAt(i) ^ 1337);
    }

    return decodedEmail;
}