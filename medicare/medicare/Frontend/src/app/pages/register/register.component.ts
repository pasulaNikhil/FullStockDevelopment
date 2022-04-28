import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginServicesService } from 'src/app/services/login-services.service';
import { UserServiceService } from 'src/app/services/user-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  constructor(
    private userService: UserServiceService,
    private snackBar: MatSnackBar,
    private _loginService: LoginServicesService
  ) {}

  ngOnInit(): void {}

  public user = {
    username: '',
    email: '',
    password: '',
    firstName: '',
    lastName: '',
    phone: 0,
  };

  formSubmit() {
    if (this.user.username === '' || this.user.username === null) {
      this.snackBar.open('username is required!', 'close', {
        duration: 3000,
      });

      return;
    }

    if (this.user.email === '' || this.user.email === null) {
      this.snackBar.open('email is required!', 'close', {
        duration: 3000,
      });

      return;
    }

    if (this.user.password === '' || this.user.password === null) {
      this.snackBar.open('email is required!', 'close', {
        duration: 3000,
      });

      return;
    }

    if (this.user.firstName === '' || this.user.firstName === null) {
      this.snackBar.open('email is required!', 'close', {
        duration: 3000,
      });

      return;
    }

    this.userService.addUser(this.user).subscribe(
      (data: any) => {
        console.log(data);
        Swal.fire(
          'success!',
          data.username + ' is successfully registered',
          'success'
        );
      },
      (error) => {
        console.log(error);
        this.snackBar.open(error.error.message, '', {
          duration: 3000,
        });
      }
    );
  }
}
