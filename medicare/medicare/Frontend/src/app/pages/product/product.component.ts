import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductServicesService } from 'src/app/services/product-services.service';
import Swal from 'sweetalert2';
import baseUrl from 'src/app/services/helper';
import { CartServiceService } from 'src/app/services/cart-service.service';
import { LoginServicesService } from 'src/app/services/login-services.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
})
export class ProductComponent implements OnInit {
  product: any;
  baseUrl: string = baseUrl;
  isOutOfStock = false;
  constructor(
    private route: ActivatedRoute,
    private productService: ProductServicesService,
    private cartService: CartServiceService,
    public loginService: LoginServicesService,
    public router: Router
  ) {}

  ngOnInit(): void {
    const routeParams = this.route.snapshot.paramMap;
    const productIdFromRoute = Number(routeParams.get('productId'));

    this.productService.getProduct(productIdFromRoute).subscribe(
      (data: any) => {
        this.product = data;
        this.isOutOfStock = this.product.stockCount === 0;
        console.log(data);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error!', 'Something went wrong', 'error');
      }
    );
  }

  addToCart() {
    if (this.loginService.getUser() == null) {
      this.router.navigate(['/login']);
      return;
    }

    let cart = {
      username: this.loginService.getUser().username,
      productId: this.product.id,
      quantity: 1,
    };
    this.cartService.addCart(cart).subscribe(
      (data: any) => {
        Swal.fire(
          'Success',
          data.product.name + ' has been added to cart',
          'success'
        );
        console.log(data);
      },
      (error: any) => {
        Swal.fire('Error', error.error.message, 'error');
      }
    );
  }
}
