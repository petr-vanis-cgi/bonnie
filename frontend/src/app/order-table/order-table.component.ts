import { Component, Input} from '@angular/core';
import { MatDialog, MatDialogConfig } from "@angular/material/dialog";
import { TrackingNumberComponent } from '../common/tracking-number/tracking-number.component';
import { Order, OrderControllerService } from 'generated-client';
import { Router } from '@angular/router';

@Component({
  selector: 'order-table',
  templateUrl: './order-table.component.html',
  styleUrls: ['./order-table.component.css']
})
export class OrderTableComponent {

  @Input() orders: Order[] = [];

  displayedColumns: string[] = ['id', 'quantity', 'status', 'assignedTo', 'trackingNr' ];

  myObserver = {
    next: (value:any) => {
      console.log('Observer got a next value: ' + value);
      this.router.navigate([this.router.url]);
    },
    error: (err:any) => { 
      console.error('Observer got an error: ' + err)
      this.router.navigate([this.router.url]);
    }
  }

  constructor(private dialog: MatDialog,private orderControllerService: OrderControllerService, private router: Router) { }
   
  openTrackingNr(order: Order): void {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    dialogConfig.data = order;

    this.dialog.open(TrackingNumberComponent, dialogConfig);
  }

  releaseOrder(order : number): void{ 
    this.orderControllerService.releaseOrder(order)
    .subscribe(this.myObserver);
  }
  claimOrder(order : number): void{ 
    this.orderControllerService.assignToMe(order) 
    .subscribe(this.myObserver);
  }

  finishOrder(order : number): void{ 
    this.orderControllerService.finishOrder(order) 
    .subscribe(this.myObserver);
  }
}
