import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root',
})
export class UserServiceService {
  constructor(private http: HttpClient) {}

  public getAllUser() {
    return this.http.get(`${baseUrl}/admin/user/`);
  }

  public addUser(user: any) {
    return this.http.post(`${baseUrl}/user/`, user);
  }
  public updateUser(user: any) {
    return this.http.put(`${baseUrl}/user/`, user);
  }
}
