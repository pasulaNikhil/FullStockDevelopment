import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { CategoryServiceService } from 'src/app/services/category-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css'],
})
export class AddCategoryComponent implements OnInit {
  constructor(
    private _categoryService: CategoryServiceService,
    private snackBar: MatSnackBar,
    private _router: Router
  ) {}

  public category: any = {
    id: 0,
    name: '',
  };

  ngOnInit(): void {
    if (this._categoryService.getCatUpdate() != null) {
      this.category = this._categoryService.getCatUpdate();
      this._categoryService.removeUpCat();
    }
    console.log(this.category);
  }

  onSubmit() {
    if (this.category.name === '' || this.category.name === null) {
      this.snackBar.open('Name is required', 'Ok', {
        duration: 3000,
      });
      return;
    }

    if (this.category.id === 0) {
      this._categoryService.addcategory(this.category).subscribe(
        (data: any) => {
          this.category.name = '';
          Swal.fire('Success', `${data.name} is successfully added`, 'success');
          this._router.navigate(['/admin/categories']);
        },
        (error) => {
          this.snackBar.open(error.error.message, '', {
            duration: 3000,
          });
        }
      );
      return;
    } else {
      this._categoryService.updateCategory(this.category).subscribe(
        (data: any) => {
          this._router.navigate(['/admin/categories']);
          Swal.fire(
            'Success',
            `${data.name} is successfully updated`,
            'success'
          );
        },
        (asd) => {
          this.snackBar.open(asd, 'ok', {
            duration: 3000,
          });
        }
      );
    }
  }
}
