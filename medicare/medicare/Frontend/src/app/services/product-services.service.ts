import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root',
})
export class ProductServicesService {
  constructor(private _http: HttpClient) {}

  public getProducts() {
    return this._http.get(`${baseUrl}/product/`);
  }

  public getProductsByCategory(id: any) {
    return this._http.get(`${baseUrl}/product/category/${id}`);
  }

  public getProductsByQuery(query: any) {
    return this._http.get(`${baseUrl}/product/search/${query}`);
  }

  public getProduct(id: number) {
    return this._http.get(`${baseUrl}/product/${id}`);
  }

  public addProduct(product: FormData): Observable<any> {
    return this._http.post(`${baseUrl}/product/`, product);
  }

  public deleteProduct(id: any) {
    return this._http.delete(`${baseUrl}/product/${id}`);
  }
  public updateProduct(product: any) {
    return this._http.put(`${baseUrl}/product/${product.id}`, product);
  }

  public setLocalUpdate(product: any) {
    localStorage.setItem('updateProduct', JSON.stringify(product));
  }

  public getLocalUpdate() {
    let localStr = localStorage.getItem('updateProduct');
    if (localStr != null) {
      return JSON.parse(localStr);
    } else {
      return null;
    }
  }

  public removeLocalUpdate() {
    localStorage.removeItem('updateProduct');
  }
}
