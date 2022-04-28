import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginServicesService } from 'src/app/services/login-services.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  loginData = {
    username: '',
    password: '',
  };
  constructor(
    private snack: MatSnackBar,
    private loginService: LoginServicesService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  login() {
    // username validation
    if (
      this.loginData.username.trim() === '' ||
      this.loginData.username === null
    ) {
      console.log('got ');
      this.snack.open('username is required', 'OK', {
        duration: 3000,
      });
      return;
    }
    // password validation
    if (
      this.loginData.password.trim() === '' ||
      this.loginData.password === null
    ) {
      console.log('got ');
      this.snack.open('password is required', 'OK', {
        duration: 3000,
      });
      return;
    }

    this.loginService.generateToken(this.loginData).subscribe(
      (data: any) => {
        console.log('success');
        console.log(data);

        this.loginService.loginUser(data.token);
        this.loginService.getCurrentUser().subscribe(
          (user: any) => {
            this.loginService.setUser(user);
            console.log(user);
            if (this.loginService.getUserRole() === 'ROLE_ADMIN') {
              this.snack.open('invalid credentials', 'ok', {
                duration: 3000,
              });
              this.loginService.logout();
              return;
            } else if (this.loginService.getUserRole() === 'ROLE_USER') {
              this.router.navigate(['/products']);
              this.loginService.loginStatus.next(true);
            } else {
              this.loginService.logout();
            }
          },
          (error) => {
            console.log(error);
            this.snack.open(error.error.message, 'OK', {
              duration: 5000,
            });
          }
        );
      },
      (error) => {
        console.log(error);
        this.snack.open('INVALID CREDENTIALS:    Please try again', '', {
          duration: 5000,
        });
      }
    );
  }
}
