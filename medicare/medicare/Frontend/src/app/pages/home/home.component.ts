import { Component, OnInit } from '@angular/core';
import baseUrl from 'src/app/services/helper';
import { ProductServicesService } from 'src/app/services/product-services.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  constructor(private productService: ProductServicesService) {}

  baseUrl = baseUrl;
  products: any;
  ngOnInit(): void {
    this.productService.getProducts().subscribe(
      (data: any) => {
        this.products = data.slice(0, 6);
      },
      (error) => {
        Swal.fire('Error', 'Something went wrong', 'error');
      }
    );
  }
}
