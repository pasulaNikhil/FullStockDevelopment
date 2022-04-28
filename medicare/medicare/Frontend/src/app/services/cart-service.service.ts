import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root',
})
export class CartServiceService {
  constructor(private _http: HttpClient) {}

  public getCart(id: any) {
    return this._http.get(`${baseUrl}/cart/${id}`);
  }

  public getCartByUser(username: any) {
    return this._http.get(`${baseUrl}/cart/user/${username}`);
  }

  public addCart(cart: any) {
    return this._http.post(`${baseUrl}/cart/`, cart);
  }

  public updateCart(id: any, cart: any) {
    return this._http.put(`${baseUrl}/cart/${id}`, cart);
  }

  public updateQuantity(id: any, quantity: any) {
    return this._http.put(`${baseUrl}/cart/${id}/${quantity}`, {});
  }

  public deleteCart(id: any) {
    return this._http.delete(`${baseUrl}/cart/${id}`);
  }

  public checkout(username: any) {
    return this._http.get(`${baseUrl}/cart/checkout/${username}`);
  }
}
