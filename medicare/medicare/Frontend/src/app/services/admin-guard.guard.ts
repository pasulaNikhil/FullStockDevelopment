import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';
import { Observable } from 'rxjs';
import { LoginServicesService } from './login-services.service';

@Injectable({
  providedIn: 'root',
})
export class AdminGuardGuard implements CanActivate {
  constructor(
    private loginService: LoginServicesService,
    private router: Router
  ) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree>
    | boolean
    | UrlTree {
    if (
      this.loginService.isLoggedin() &&
      this.loginService.getUserRole() === 'ROLE_ADMIN'
    ) {
      return true;
    }
    this.router.navigate(['login']);
    return false;
  }
}
