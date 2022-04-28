import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { CategoryServiceService } from 'src/app/services/category-service.service';
import { ProductServicesService } from 'src/app/services/product-services.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-products',
  templateUrl: './view-products.component.html',
  styleUrls: ['./view-products.component.css'],
})
export class ViewProductsComponent implements OnInit, AfterViewInit {
  products: any = [];
  categories: any = [];
  categoryId: any;

  constructor(
    private _product: ProductServicesService,
    private _categoryService: CategoryServiceService,
    private _snackBar: MatSnackBar,
    private _router: Router
  ) {}

  displayedColumns: string[] = [
    'id',
    'name',
    'category',
    'stockCount',
    'price',
    'weight',
    'update',
    'delete',
  ];

  dataSource: any;

  @ViewChild(MatPaginator) paginator: any;

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
        this.dataSource = new MatTableDataSource<any>(this.products);
        console.log(data);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error!', 'Something went wrong', 'error');
      }
    );
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  onCategoryChange() {
    if (this.categoryId == 0 || this.categoryId == null) {
      this._product.getProducts().subscribe(
        (data: any) => {
          this.products = data;
          this.dataSource = new MatTableDataSource<any>(this.products);
          console.log(data);
        },
        (error) => {
          console.log(error);
          Swal.fire('Error!', 'Something went wrong', 'error');
        }
      );
      return;
    }
    this._product.getProductsByCategory(this.categoryId).subscribe(
      (data: any) => {
        this.products = data;
        this.dataSource = new MatTableDataSource<any>(this.products);
        console.log(data);
      },
      (error: any) => {
        console.log(error);
        Swal.fire('Error!', 'Something went wrong', 'error');
      }
    );
  }

  update(product: any) {
    this._product.setLocalUpdate(product);
    this._router.navigate(['/admin/add-product']);
  }

  delete(id: any, name: any) {
    this._product.deleteProduct(id).subscribe(
      (data) => {
        console.log(data);
        Swal.fire('Success', name + ' is successfully deleted', 'success');
        this._product.getProducts().subscribe(
          (data: any) => {
            this.products = data;
            this.dataSource = new MatTableDataSource<any>(this.products);
            console.log(data);
          },
          (error) => {
            console.log(error);
            Swal.fire('Error!', 'Something went wrong', 'error');
          }
        );
      },
      (error) => {
        console.log(error);
        this._snackBar.open('something went wrong', 'ok', {
          duration: 3000,
        });
      }
    );
  }
}
