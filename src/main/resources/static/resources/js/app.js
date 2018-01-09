// accessible globally
// useful for storing configs and such-like
var App = {
    initConfig: function (config) {
        this.config = jQuery.extend({
            obfuscationKey: 0
        }, config || {});

        console.log(this.config);
    }
};