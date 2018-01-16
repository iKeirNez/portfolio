import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Site } from './site';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'

@Injectable()
export class SiteService {

  private sites = new Map<number, Site>();

  constructor(private http: HttpClient) { }

  getLiveSite(): Observable<Site> {
    return this.getSite(1);
  }

  getSite(id: number): Observable<Site> {
    if (this.sites.has(id)) {
      return Observable.of(this.sites.get(id));
    } else {
      return this.http.get('/api/sites/' + id)
        .map((data: any) => this.processSite(data))
        .map((data: any) => data as Site);
    }
  }

  // TODO this isn't 'typed' - it would be nice if it was
  private processSite(siteJson: any): any {
    for (var jobJson of siteJson.profile.jobs) {
      if (jobJson.from) {
        jobJson.from = new Date(jobJson.from);
      }

      if (jobJson.to) {
        jobJson.to = new Date(jobJson.to);
      }
    }

    for (var educationJson of siteJson.profile.educations) {
      if (educationJson.from) {
        educationJson.from = new Date(educationJson.from);
      }

      if (educationJson.to) {
        educationJson.to = new Date(educationJson.to);
      }
    }

    // TODO should we be modifying the original object?
    return siteJson;
  }
}
