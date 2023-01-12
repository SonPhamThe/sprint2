import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { TokenService } from 'src/app/service/account/token.service';

@Injectable({
  providedIn: 'root'
})
export class AdminGuard implements CanActivate {
  constructor(private tokenService:TokenService,
    private router:Router){

  }
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      if (this.tokenService.isLogged()) {
        const roles = this.tokenService.getRole();
        for (let i = 0; i < roles.length; i++) {
          if ((roles[i]) === 'ROLE_ADMIN') {
            return true;
          }
        }  
        this.router.navigate(['']);
      } else {
        this.router.navigate(['login'])
      }
  }  
}
