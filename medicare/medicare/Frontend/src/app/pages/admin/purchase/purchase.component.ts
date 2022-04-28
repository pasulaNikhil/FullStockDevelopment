import { Component, OnInit } from '@angular/core';
import { PurchaseServiceService } from 'src/app/services/purchase-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-purchase',
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.css'],
})
export class PurchaseComponent implements OnInit {
  purchases: any = [];
  constructor(private purchaseService: PurchaseServiceService) {}

  ngOnInit(): void {
    this.purchaseService.getPurchase().subscribe(
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
