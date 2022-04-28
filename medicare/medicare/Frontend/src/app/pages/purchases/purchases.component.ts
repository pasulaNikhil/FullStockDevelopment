import { Component, OnInit } from '@angular/core';
import { LoginServicesService } from 'src/app/services/login-services.service';
import { PurchaseServiceService } from 'src/app/services/purchase-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-purchases',
  templateUrl: './purchases.component.html',
  styleUrls: ['./purchases.component.css'],
})
export class PurchasesComponent implements OnInit {
  purchases: any = [];
  constructor(
    private purchaseService: PurchaseServiceService,
    private loginService: LoginServicesService
  ) {}

  ngOnInit(): void {
    this.purchaseService
      .getPurchaseByUser(this.loginService.getUser().username)
      .subscribe(
        (data: any): void => {
          this.purchases = data;
        },
        (error: any) => {
          console.log(error);
          Swal.fire('Error!', 'Something went wrong', 'error');
        }
      );
  }
}
