import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { CategoryServiceService } from 'src/app/services/category-service.service';
import baseUrl from 'src/app/services/helper';
import { ProductServicesService } from 'src/app/services/product-services.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css'],
})
export class ShopComponent implements OnInit {
  categories: any;
  products: any;
  baseUrl = baseUrl;
  searchQuery: string = '';

  constructor(
    private _product: ProductServicesService,
    private _categoryService: CategoryServiceService,
    private _snackBar: MatSnackBar,
    private _router: Router
  ) {}

  ngOnInit(): void {
    this._categoryService.getCategories().subscribe(
      (data: any) => {
        this.categories = data;
        console.log(data);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error!', 'Something went wrong', 'error');
      }
    );

    this._product.getProducts().subscribe(
      (data: any) => {
        this.products = data;
        console.log(data);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error!', 'Something went wrong', 'error');
      }
    );
  }

  onCategoryChange(id: any) {
    console.log(id);
    if (id == 0 || id == null) {
      this._product.getProducts().subscribe(
        (data: any) => {
          this.products = data;

          console.log(data);
        },
        (error) => {
          console.log(error);
          Swal.fire('Error!', 'Something went wrong', 'error');
        }
      );
      return;
    }
    this._product.getProductsByCategory(id).subscribe(
      (data: any) => {
        this.products = data;
        console.log(data);
      },
      (error: any) => {
        console.log(error);
        Swal.fire('Error!', 'Something went wrong', 'error');
      }
    );
  }

  onSearch() {
    if (this.searchQuery.trim() === '') {
      this.onCategoryChange(0);
      return;
    }

    this._product.getProductsByQuery(this.searchQuery).subscribe(
      (data: any) => {
        this.products = data;
        console.log(data);
      },
      (error: any) => {
        console.log(error);
        Swal.fire('Error!', 'Something went wrong', 'error');
      }
    );
  }

  sortPriceInc() {
    this.products.sort((a: any, b: any) => {
      return a.price - b.price;
    });
  }

  sortPriceDec() {
    this.products.sort((a: any, b: any) => {
      return b.price - a.price;
    });
  }

  sortNameAZ() {
    this.products.sort((a: any, b: any) => {
      let fa = a.name.toLowerCase(),
        fb = b.name.toLowerCase();

      if (fa < fb) {
        return -1;
      }
      if (fa > fb) {
        return 1;
      }
      return 0;
    });
  }

  sortNameZA() {
    this.products.sort((a: any, b: any) => {
      let fa = a.name.toLowerCase(),
        fb = b.name.toLowerCase();

      if (fa < fb) {
        return 1;
      }
      if (fa > fb) {
        return -1;
      }
      return 0;
    });
  }
}
