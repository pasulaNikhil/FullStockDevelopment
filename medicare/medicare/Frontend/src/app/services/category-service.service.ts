import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root',
})
export class CategoryServiceService {
  public categoryUpdateStatus = new Subject<any>();
  constructor(private _http: HttpClient) {}

  public setCatUpdate(category: any) {
    localStorage.setItem('updateCategory', JSON.stringify(category));
  }

  public getCatUpdate() {
    let upCatStr = localStorage.getItem('updateCategory');
    if (upCatStr != null) {
      return JSON.parse(upCatStr);
    } else {
      return null;
    }
  }

  public getCategories() {
    return this._http.get(`${baseUrl}/category/`);
  }

  public addcategory(category: any) {
    return this._http.post(`${baseUrl}/category/`, category);
  }

  public deleteCategory(id: any) {
    return this._http.delete(`${baseUrl}/category/${id}`);
  }
  public updateCategory(category: any) {
    return this._http.put(`${baseUrl}/category/`, category);
  }
  public removeUpCat() {
    localStorage.removeItem('updateCategory');
  }
}
