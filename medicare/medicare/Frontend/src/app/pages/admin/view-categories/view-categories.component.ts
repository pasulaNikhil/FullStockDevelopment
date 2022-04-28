import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { CategoryServiceService } from 'src/app/services/category-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-categories',
  templateUrl: './view-categories.component.html',
  styleUrls: ['./view-categories.component.css'],
})
export class ViewCategoriesComponent implements OnInit {
  categories: any = [];

  constructor(
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
  }

  delete(category: any) {
    this._categoryService.deleteCategory(category.id).subscribe(
      (data) => {
        console.log(data);
        Swal.fire(
          'Success',
          category.name + ' is successfully deleted',
          'success'
        );
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
      },
      (error) => {
        console.log(error);
        this._snackBar.open('something went wrong', 'ok', {
          duration: 3000,
        });
      }
    );
  }

  update(category: any) {
    this._categoryService.setCatUpdate(category);
    this._router.navigate(['/admin/add-category']);
  }
}
