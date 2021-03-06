<header class="header">
    <div class="container">
        <img class="profile-image img-circle img-responsive pull-left" src="${fw.url('profile.png')}" alt="${profile.fullName}" />
        <div class="profile-content pull-left">
            <h1 class="full-name">${profile.fullName}</h1>
            <h2 class="job-title">${profile.jobTitle}</h2>
            <ul class="social list-inline">
                <li><a href="https://github.com/iKeirNez" target="_blank"><i class="fa fa-github-alt"></i></a></li>
                <li><a href="https://uk.linkedin.com/in/ikeirnez" target="_blank"><i class="fa fa-linkedin"></i></a></li>
                <li><a href="https://twitter.com/iKeirNez" target="_blank"><i class="fa fa-twitter"></i></a></li>
                <#-- TODO: add more social buttons here -->
            </ul>
        </div>
        <a class="btn btn-cta-primary pull-right" target="_blank" data-obfuscated-email="${profile.obfuscatedEmail}">
            <i class="fa fa-paper-plane"></i> Contact Me
        </a>
    </div>
</header>