import { Component, OnInit } from '@angular/core';
import { LoginServicesService } from 'src/app/services/login-services.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  isLoggedIn: boolean = false;
  user: any = null;
  constructor(public loginService: LoginServicesService) {}

  ngOnInit(): void {
    this.isLoggedIn = this.loginService.isLoggedin();
    this.user = this.loginService.getUser();
    this.loginService.loginStatus.asObservable().subscribe((data) => {
      this.isLoggedIn = this.loginService.isLoggedin();
      this.user = this.loginService.getUser();
    });
  }

  logout() {
    this.loginService.logout();
    window.location.href = '/login';
  }
}
