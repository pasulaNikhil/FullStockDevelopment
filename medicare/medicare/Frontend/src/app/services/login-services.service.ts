import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root',
})
export class LoginServicesService {
  public loginStatus = new Subject<boolean>();
  public updateUserSubject = new Subject<boolean>();

  constructor(private http: HttpClient) {}

  public getCurrentUser() {
    return this.http.get(`${baseUrl}/current-user`);
  }

  public generateToken(loginData: any) {
    return this.http.post(`${baseUrl}/generate-token`, loginData);
  }

  public loginUser(jwtToken: string) {
    localStorage.setItem('jwtToken', jwtToken);
    return true;
  }

  public isLoggedin() {
    let jwtToken = localStorage.getItem('jwtToken');
    if (jwtToken === undefined || jwtToken === '' || jwtToken === null) {
      return false;
    } else {
      return true;
    }
  }

  public logout() {
    localStorage.removeItem('jwtToken');
    localStorage.removeItem('user');
    return true;
  }

  public getToken() {
    return localStorage.getItem('jwtToken');
  }

  public setUser(user: any) {
    localStorage.setItem('user', JSON.stringify(user));
  }

  public getUser() {
    let userStr = localStorage.getItem('user');
    if (userStr != null) {
      return JSON.parse(userStr);
    } else {
      this.logout();
      return null;
    }
  }

  public getUserRole() {
    let user = this.getUser();
    return user.authorities[0].authority;
  }
}
