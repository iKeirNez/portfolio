<script type="application/javascript" src="${fw.url('resources/js/app.js')}"></script>
<script type="application/javascript">
    document.addEventListener('DOMContentLoaded', function () {
        App.initConfig({
            obfuscationKey: ${appConfig.obfuscationKey?string.computer}
        });
    });
</script>