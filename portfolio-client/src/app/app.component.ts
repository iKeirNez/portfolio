import { Component, OnInit } from '@angular/core';
import { SiteService } from './site.service';
import { Site } from './site';
import { Title } from '@angular/platform-browser';
import { Profile } from './profile';
import { ProfileService } from './profile.service';
import { Observable } from 'rxjs/Rx';
import { ProfileBasic, OccupationBasic } from './profile-basic';
import { Job } from './job';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Karo';

  site: Site;
  profile: Profile;

  basicProfile: ProfileBasic;

  constructor(private titleService: Title, private siteService: SiteService, private profileService: ProfileService) { }

  ngOnInit() {
    this.siteService.getSite(1).subscribe(site => {
      this.site = site;
      console.log('site', this.site);

      this.titleService.setTitle(site.title + ' | Karo');

      this.profileService.getProfile(site.profileId).subscribe(profile => {
        this.profile = profile;
        console.log('profile', this.profile);

        let currentJob = profile.jobs.find(j => j.to === null);
        let basicOccupation: OccupationBasic = new OccupationBasic(currentJob.organisation, currentJob.website);
        this.basicProfile = new ProfileBasic(profile.location, basicOccupation);
        console.log('basic profile', this.basicProfile);
      });
    });
  }
}
