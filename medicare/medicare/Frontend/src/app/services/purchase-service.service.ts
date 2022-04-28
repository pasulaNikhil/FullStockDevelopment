import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import baseUrl from './helper';

@Injectable({
  providedIn: 'root',
})
export class PurchaseServiceService {
  constructor(private _http: HttpClient) {}

  public getPurchase() {
    return this._http.get(`${baseUrl}/purchase/`);
  }

  public getPurchaseByUser(username: any) {
    return this._http.get(`${baseUrl}/purchase/${username}`);
  }
}
