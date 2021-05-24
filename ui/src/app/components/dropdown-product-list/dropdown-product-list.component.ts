import { Component, OnInit } from "@angular/core";
import { OrderDetailsService } from "src/app/services/order-details.service";

@Component({
  selector: "app-dropdown-product-list",
  templateUrl: "./dropdown-product-list.component.html",
  styleUrls: ["./dropdown-product-list.component.scss"],
})
export class DropdownProductListComponent implements OnInit {
  items: any;

  constructor(private _orderDetailsService: OrderDetailsService) {}

  ngOnInit() {
    this._orderDetailsService.getOrderDetails(198772).then((data: any) => {
      this.items = data.items;
    });
  }
}
