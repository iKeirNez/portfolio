import { Component } from '@angular/core';
import { SiteService } from './site.service';
import { Site } from './site';
import { Title } from '@angular/platform-browser';
import { Profile } from './profile';
import { ProfileService } from './profile.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Karo';

  site: Site;
  profile: Profile;

  constructor(private titleService: Title, private siteService: SiteService, private profileService: ProfileService) { }

  ngOnInit() {
    this.siteService.getSite(1).subscribe(site => {
      this.site = site;
      this.titleService.setTitle(site.title + ' | Karo');

      console.log(site);
      this.profileService.getProfile(site.profile).subscribe(profile => this.profile = profile);
    });


  }
}
