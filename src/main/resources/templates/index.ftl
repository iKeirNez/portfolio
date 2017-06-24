<#import "layout/utils.ftl" as utils>
<@utils.mainLayout "${profile.fullName} | ${profile.jobTitle}">
<div class="container sections-wrapper">
    <div class="row">
        <div class="primary col-md-8 col-sm-12 col-xs-12">
            <section class="about section">
                <div class="section-inner">
                    <h2 class="heading">About Me</h2>
                    <div class="content">
                        I'm <span data-age-prefix="true" data-years-since="${profile.birthDateOffset}"></span>-year-old
                        developer based in ${profile.location}, I specialise in developing back-end software
                        solutions, the majority of these have been solved using Java, PHP &amp; MySQL. I always enjoy
                        expanding my knowledge and skillset by learning new technologies, I can then use this new
                        knowledge to tackle more complex challenges. I've always had a very deep interest in
                        technology from a young age, especially in the programming field.
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
                                <span class="year">(December 2016 - Present)</span>
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
                            <li><i class="fa fa-fw fa-map-pin"></i><span class="sr-only">Location: </span>${profile.location}</li>
                            <li><i class="fa fa-fw fa-briefcase"></i><span class="sr-only">Company:</span><a href="https://www.cubecraft.net" target="_blank">CubeCraft Games</a></li>
                            <li><i class="fa fa-fw fa-key"></i><span class="sr-only">PGP: </span><a href="https://keybase.io/keir_nellyer" target="_blank">279B 64A7 971B 4FF4</a></li>
                        </ul>
                    </div>
                </div>
            </aside>
        </div>
    </div>
</div>
</@utils.mainLayout>