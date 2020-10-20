import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  url = environment.apiUrl;
  constructor(private http: HttpClient){
  }

  public send(user): Observable<any>{
    return this.http.post(this.url, user);

  }
}
