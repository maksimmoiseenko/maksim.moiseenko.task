import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TokenInterceptor implements HttpInterceptor {
  constructor() {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    if (req.url.indexOf('login') !== -1 ) {
      return next.handle(req);
    }

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
    return next.handle(req);

  }
}
