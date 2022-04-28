import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { UserServiceService } from 'src/app/services/user-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css'],
})
export class UserListComponent implements OnInit {
  users: any = [];
  constructor(private _userService: UserServiceService) {}

  displayedColumns: string[] = [
    'id',
    'username',
    'firstName',
    'lastName',
    'phone',
    'email',
    'role',
  ];

  dataSource: any;

  @ViewChild(MatPaginator) paginator: any;

  ngOnInit(): void {
    this._userService.getAllUser().subscribe(
      (data: any) => {
        console.log(data);
        this.users = data;

        this.dataSource = new MatTableDataSource<any>(this.users);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error!', 'Something went wrong', 'error');
      }
    );
  }
}
