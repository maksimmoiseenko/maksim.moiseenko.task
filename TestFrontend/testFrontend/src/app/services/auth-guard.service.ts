import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';

class RouterService {
}

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {
  constructor(private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const token = localStorage.getItem('token');
    const role = localStorage.getItem('role');
    if (token) {
      if (route.data.role && route.data.role.indexOf(role) === -1) {
        this.router.navigate(['/sensors']);
        return false;
      }
      return true;
    }
    this.router.navigate(['/login']);
    return false;
  }
}
