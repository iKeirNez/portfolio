<#macro mainLayout title="">
<!DOCTYPE html>
<html>
<head lang="en">
    <title>${title}</title>

    <!-- Setup Responsive Environment -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,300italic,400italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link id="theme-style" rel="stylesheet" href="${fw.url('resources/css/main.css')}">
</head>
<body>
    <#include "header.ftl">
    <#nested>
    <#include "footer.ftl">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <#include "app.ftl">
    <script src="${fw.url('resources/js/obfuscate.js')}"></script>
</body>
</html>
</#macro>

<#-- May need moved server-side if we expand to other platforms -->
<#function agePrefix age>
    <#-- If number sounds like it starts with 'eight' -->
    <#if age == 8 || age == 18 || (age >= 80 && age < 90)>
        <#return 'an'>
    <#else>
        <#return 'a'>
    </#if>
</#function>