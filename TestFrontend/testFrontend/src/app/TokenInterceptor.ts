import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TokenInterceptor implements HttpInterceptor {
  constructor() {
  }
  baseUrl = environment.apiUrl;

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    if (req.url.includes(this.baseUrl)){
      const token = localStorage.getItem('token');
      console.log(token);
      if (token) {
        const reqWithAuth = req.clone({
          setHeaders: {
            Authorization: 'Bearer ' + token
          }
        });
        return next.handle(reqWithAuth);
      }
    }
    return next.handle(req);
  }
}
