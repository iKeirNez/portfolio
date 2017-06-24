/*
Email address obfuscation is done to prevent spam bots from crawling the site and scraping email addresses, this is
done in the background the end user will have no idea this is taking place.

Email addresses are encoded by doing bitwise XOR on each character integer value and then decoded by repeating
the process.
 */

// must be equal to backend
const MAGIC_NUMBER = 1337;

jQuery(document).ready(function($) {

    // encoded email address is stored in the `data-obfuscated-email` property
    // email address is decoded when user hovers or clicks the button
    $('a[data-obfuscated-email]').on('mouseover.uncensor click.uncensor', function() {
        var decoded = xorString($(this).data('obfuscate'), $(this));

        // set href to decoded email address
        $(this).attr('href', "mailto:" + decoded);

        // disable this event handler, doesn't need run again
        $(this).off('mouseover.uncensor click.uncensor');
    });
});

function xorString(encodedEmail) {
    var decodedEmail = '';

    for (var i = 0; i < encodedEmail.length; i++) {
        decodedEmail += String.fromCharCode(encodedEmail.charCodeAt(i) ^ MAGIC_NUMBER);
    }

    return decodedEmail;
}