import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { CategoryServiceService } from 'src/app/services/category-service.service';
import baseUrl from 'src/app/services/helper';
import { ProductServicesService } from 'src/app/services/product-services.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css'],
})
export class AddProductComponent implements OnInit {
  product: any = {
    id: 0,
    name: '',
    description: '',
    price: '',
    weight: '',
    stockCount: 0,
    categoryId: 0,
    brand: '',
  };
  public image: any = File;

  categories: any = [];

  constructor(
    private _categoryService: CategoryServiceService,
    private _productService: ProductServicesService,
    private snackBar: MatSnackBar,
    private _router: Router
  ) {}

  ngOnInit(): void {
    if (this._productService.getLocalUpdate() != null) {
      let productUpdate = this._productService.getLocalUpdate();
      this.product = productUpdate;
      this.product.categoryId = productUpdate.category.id;
      this._productService.removeLocalUpdate();
    } else {
      console.log('not working');
    }

    this._categoryService.getCategories().subscribe(
      (data: any) => {
        this.categories = data;
      },
      (error) => {
        console.log(error);
        Swal.fire(
          'Error!',
          'Something went wrong! Cannot load categories',
          'error'
        );
      }
    );
  }

  onImageUpload(event: any) {
    const file = event.target.files[0];
    console.log(file);
    this.image = file;
  }

  onSubmit() {
    if (this.product.name.trim() === '' || this.product.name === null) {
      this.snackBar.open('Name is required', 'Ok', {
        duration: 3000,
      });
      return;
    }
    if (this.product.price === null || this.product.price === 0) {
      this.snackBar.open('price is required', 'Ok', {
        duration: 3000,
      });
      return;
    }
    if (this.product.brand === null || this.product.brand.trim() === '') {
      this.snackBar.open('brand is required', 'Ok', {
        duration: 3000,
      });
      return;
    }
    if (this.product.categoryId === 0 || this.product.categoryId === null) {
      this.snackBar.open('category is required', 'Ok', {
        duration: 3000,
      });
      return;
    }
    if (this.product.weight === 0 || this.product.weight === null) {
      this.snackBar.open('weight is required', 'Ok', {
        duration: 3000,
      });
      return;
    }

    if (this.product.id === 0) {
      if (this.image === null) {
        this.snackBar.open('image is required', 'Ok', {
          duration: 3000,
        });
        return;
      }

      let formData = new FormData();
      formData.append('product', JSON.stringify(this.product));
      formData.append('image', this.image);

      this._productService.addProduct(formData).subscribe(
        (data: any) => {
          Swal.fire('Success', `${data.name} is successfully added`, 'success');
          this._router.navigate(['/admin/products']);
        },
        (error: any) => {
          this.snackBar.open(error.error.message, 'ok', {
            duration: 3000,
          });
        }
      );
    } else {
      this._productService.updateProduct(this.product).subscribe(
        (data: any) => {
          Swal.fire(
            'Success',
            `${data.name} is successfully updated`,
            'success'
          );
          this._router.navigate(['/admin/products']);
        },
        (error: any) => {
          this.snackBar.open(error.error.message, 'ok', {
            duration: 3000,
          });
        }
      );
    }
  }
}
