$(document).ready(function() {
    $('span[data-years-since]').html(function() {
        var dateTimeRaw = $(this).data('years-since');
        var dateTimeParsed = moment.parseZone(dateTimeRaw);
        var yearsSince = getYearsSince(dateTimeParsed);
        var prefix = '';

        if ($(this).data('age-prefix')) {
            if (yearsSince === 8 || yearsSince === 18 || (yearsSince >= 80 && yearsSince < 90)) {
                prefix = 'an ';
            } else {
                prefix = 'a ';
            }
        }

        return prefix + yearsSince;
    });
});

function getYearsSince(dateTime) {
    return Math.floor(moment().diff(dateTime, 'years', true));
}