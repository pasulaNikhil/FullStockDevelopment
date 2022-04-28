import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CartServiceService } from 'src/app/services/cart-service.service';
import baseUrl from 'src/app/services/helper';
import { LoginServicesService } from 'src/app/services/login-services.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent implements OnInit {
  cartProducts: any = {};
  baseUrl = baseUrl;
  total: any;
  isEmpty: boolean = false;

  constructor(
    private cartService: CartServiceService,
    private loginService: LoginServicesService,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {
    this.cartService
      .getCartByUser(this.loginService.getUser().username)
      .subscribe(
        (data: any) => {
          this.cartProducts = data;
          this.cartProducts.length === 0
            ? (this.isEmpty = true)
            : (this.isEmpty = false);
          this.calculateTotal();
          console.log(data);
        },
        (error) => {
          console.log(error);
          Swal.fire('Error!', 'Something went wrong', 'error');
        }
      );
  }

  deleteProduct(id: any) {
    this.cartService.deleteCart(id).subscribe(
      (data: any) => {
        this.refreshCart();
        console.log(data);
      },
      (error: any) => {
        console.log(error);
        Swal.fire('Error!', 'Something went wrong', 'error');
      }
    );
  }

  calculateTotal() {
    this.total = 0;
    for (let i = 0; i < this.cartProducts.length; i++) {
      this.total =
        this.cartProducts[i].product.price * this.cartProducts[i].quantity +
        this.total;
    }
  }

  quantityDec(id: any, quantity: any) {
    if (quantity == 1) {
      this.snackBar.open('quantity cannot be less than 1!', 'close', {
        duration: 3000,
      });
      return;
    }

    quantity--;
    this.cartService.updateQuantity(id, quantity).subscribe(
      (data) => {
        console.log(data);
        this.refreshCart();
      },
      (error) => {
        console.log(error);
        Swal.fire('Error!', 'Something went wrong', 'error');
      }
    );
  }

  quantityInc(id: any, quantity: any) {
    if (quantity == 5) {
      this.snackBar.open('quantity cannot be more than 5!', 'close', {
        duration: 3000,
      });
      return;
    }
    quantity++;
    this.cartService.updateQuantity(id, quantity).subscribe(
      (data) => {
        console.log(data);
        this.refreshCart();
      },
      (error) => {
        if (error.status === 400) {
          this.snackBar.open(
            'You cannot add more products we are out of stock!',
            'close',
            {
              duration: 3000,
            }
          );

          return;
        }

        console.log(error);
        Swal.fire('Error!', 'Something went wrong', 'error');
      }
    );
  }

  refreshCart() {
    this.cartService
      .getCartByUser(this.loginService.getUser().username)
      .subscribe(
        (data: any) => {
          this.cartProducts = data;
          this.cartProducts.length === 0
            ? (this.isEmpty = true)
            : (this.isEmpty = false);
          this.calculateTotal();
          console.log(data);
        },
        (error) => {
          console.log(error);
          Swal.fire('Error!', 'Something went wrong', 'error');
        }
      );
  }

  checkout() {
    this.cartService.checkout(this.loginService.getUser().username).subscribe(
      (data: any) => {
        Swal.fire(
          'Successfully purchased',
          'we have successfully placed your order',
          'success'
        );
      },
      (error) => {
        Swal.fire('Error', 'Something went wrong', 'error');
      }
    );
  }
}
