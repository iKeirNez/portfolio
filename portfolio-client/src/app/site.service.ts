import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Site } from './site';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class SiteService {

  constructor(private http: HttpClient) { }

  getSite(id: number): Observable<Site> {
    return this.http.get<Site>('/api/sites/' + id);
  }
}
