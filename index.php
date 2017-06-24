<?php
    $timezone = new DateTimeZone('Europe/London');
    $dob = DateTime::createFromFormat('d/m/Y', '12/01/1999', $timezone);

    function getAgeString() {
        $years = getAge()->y;
        return getAgePrefix($years) . ' ' . $years;
    }

    function getAgePrefix($age) {
        // if age sounds like it starts with 'eight' - return 'an'
        if ($age == 8 || $age == 18 || ($age >= 80 && $age < 90)) {
            return 'an';
        } else {
            return 'a';
        }
    }

    function getAge() {
        global $timezone, $dob;
        return $dob->diff(new DateTime('now', $timezone));
    }
?>
<!DOCTYPE html>
<html>
<head>
    <title>Keir Nellyer | Software Engineer</title>

    <!-- Setup Responsive Environment -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,300italic,400italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <?php if (false): ?>
        <!-- Hack to force IntelliJ IDEA to perform code completion (as these are CDN'd) -->
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap-theme.css">
        <link rel="stylesheet" href="css/font-awesome.css">
    <?php endif; ?>

    <link id="theme-style" rel="stylesheet" href="css/main.css">
</head>
<body>
<header class="header">
    <div class="container">
        <img class="profile-image img-circle img-responsive pull-left" src="profile.png" alt="Keir Nellyer" />
        <div class="profile-content pull-left">
            <h1 class="full-name">Keir Nellyer</h1>
            <h2 class="job-title">Software Engineer</h2>
            <ul class="social list-inline">
                <li><a href="https://github.com/iKeirNez" target="_blank"><i class="fa fa-github-alt"></i></a></li>
                <li><a href="https://uk.linkedin.com/in/ikeirnez" target="_blank"><i class="fa fa-linkedin"></i></a></li>
                <li><a href="https://twitter.com/iKeirNez" target="_blank"><i class="fa fa-twitter"></i></a></li>
                <!-- TODO add more social buttons here -->
            </ul>
        </div>
        <a class="btn btn-cta-primary pull-right email" href="mailto:keir@bad-domain.co.uk" target="_blank"><i class="fa fa-paper-plane"></i> Contact Me</a>
    </div>
</header>

<div class="container sections-wrapper">
    <div class="row">
        <div class="primary col-md-8 col-sm-12 col-xs-12">
            <section class="about section">
                <div class="section-inner">
                    <h2 class="heading">About Me</h2>
                    <div class="content">
                        I'm <?= getAgeString() ?>-year-old developer based in Dunfermline, Scotland, I specialise in
                        developing back-end software solutions, the majority of these have been solved using Java, PHP
                        &amp; MySQL. I always enjoy expanding my knowledge and skillset by learning new technologies, I
                        can then use this new knowledge to tackle more complex challenges. I've always had a very deep
                        interest in technology from a young age, especially in the programming field.
                    </div>
                </div>
            </section>
            <section class="experience section">
                <div class="section-inner">
                    <h2 class="heading">Work Experience</h2>
                    <div class="content">
                        <div class="item">
                            <h3 class="title">Service Developer
                                <span class="place"><a href="https://www.cubecraft.net">CubeCraft Games</a></span>
                                <span class="year">(December 2016 - June 2017)</span>
                            </h3>
                            <p>
                                Newly hired by CubeCraft to develop various services for their large Minecraft
                                multiplayer server.
                            </p>
                        </div>
                        <div class="item">
                            <h3 class="title">Software Engineer
                                <span class="place"><a href="http://mineplex.com">Mineplex, LLC</a></span>
                                <span class="year">(October 2015 - November 2016)</span>
                            </h3>
                            <p>
                                Worked on mostly backend server solutions for one of the largest Minecraft multiplayer
                                networks, these solutions occasionally had to be capable of communicating across
                                multiple server instances (accomplished using Redis). I spent most of my time there
                                working on non-games/player lobby features. I also had to design and implement a backend
                                database structure and create PHP scripts to dynamically generate web pages to fetch,
                                process and display data from said database.
                            </p>
                        </div>
                        <div class="item">
                            <h3 class="title">Lead Developer
                                <span class="place"><a href="https://minecraftly.com">Minecraftly</a></span>
                                <span class="year">(October 2012 - April 2016)</span>
                            </h3>
                            <p>
                                Worked as lead developer of a highly ambitious project to allow massive amounts of
                                players to host their own Minecraft worlds and invite their friends to join them in
                                their world. The backend servers were designed to be infinitely scalable by using
                                multiple Google Compute instances to distribute the load, these would dynamically scale
                                up or down depending on server traffic. This allowed the system to be effectively
                                limitless.
                            </p>
                        </div>
                        <div class="item">
                            <h3 class="title">Software Developer
                                <span class="place">Puzl Inc.</span>
                                <span class="year">(August 2015 - November 2015)</span>
                            </h3>
                            <p>
                                Developed server-side applications based on specification provided by clients which had
                                been sourced by Puzl Inc. These projects mainly made use of Java, MySQL and the
                                <a href="http://bukkit.org">Bukkit API</a>. This involved working directly with the
                                client and ensuring they were satisfied with the end product by implementing requested
                                changes and additions in a timely manner.
                            </p>
                        </div>
                    </div>
                </div>
            </section>
            <section class="experience section">
                <div class="section-inner">
                    <h2 class="heading">Education</h2>
                    <div class="content">
                        <div class="item">
                            <h3 class="title">Software Development (HND)
                                <span class="place">Fife College - Priory/St. Brycedale Campus</span>
                                <span class="year">(August 2015 - June 2017)</span>
                            </h3>
                            <p>
                                Covered many aspects of software design, troubleshooting and implementation as well as
                                project planning. During this time I experimented with many languages and technologies
                                including C++, MySQL, PHP, JavaScript, Java and JSP amongst others. I completed the
                                course with a grade A.
                            </p>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <div class="secondary col-md-4 col-sm-12 col-xs-12">
            <aside class="info aside section">
                <div class="section-inner">
                    <h2 class="heading sr-only">Basic Information</h2>
                    <div class="content">
                        <ul class="list-unstyled">
                            <li><i class="fa fa-fw fa-map-pin"></i><span class="sr-only">Location: </span>Dunfermline, UK</li>
                            <li><i class="fa fa-fw fa-briefcase"></i><span class="sr-only">Company:</span><a href="http://www.airts.co.uk/" target="_blank">Airts</a></li>
                            <li><i class="fa fa-fw fa-key"></i><span class="sr-only">PGP: </span><a href="https://keybase.io/keir_nellyer" target="_blank">279B 64A7 971B 4FF4</a></li>
                        </ul>
                    </div>
                </div>
            </aside>
        </div>
    </div>
</div>

<footer class="footer">
    <div class="container text-center">
        <div class="footer-content">
            Copyright &copy; <?= date("Y") ?> Keir Nellyer
        </div>
    </div>
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>

</body>
</html>