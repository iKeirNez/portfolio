import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Profile } from './profile';

@Injectable()
export class ProfileService {

  constructor(private http: HttpClient) { }

  public getProfile(id: number): Observable<Profile> {
    return this.http.get<Profile>('/api/profiles/' + id);
  }

}
