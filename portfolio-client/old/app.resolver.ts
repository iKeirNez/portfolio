import { Injectable } from "@angular/core";
import { Resolve } from '@angular/router';
import { SiteService } from "./site.service";
import { ProfileService } from "./profile.service";
import { Observable } from "rxjs/Observable";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/mergeMap'; // contains flatMap method
import 'rxjs/add/operator/catch';

@Injectable()
export class AppResolver implements Resolve<Observable<any>> {

  constructor(private siteService: SiteService, private profileService: ProfileService) { }

  resolve(): Observable<any> {
    console.log('resolving');
    return this.siteService.getSite(1).flatMap(site => {
      return this.profileService.getProfile(site.profileId).map(profile => {
        return {
          site: site,
          profile: profile
        }
      })
    }).catch(error => Observable.throw(error));
  }
}
