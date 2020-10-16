import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private url = 'http://localhost:8080/login';
  constructor(private http: HttpClient){
  }

  public send(user): Observable<any>{
    return this.http.post(this.url, user);
  }
}
