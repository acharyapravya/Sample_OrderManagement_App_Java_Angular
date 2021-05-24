import { Component, Input, OnInit } from "@angular/core";
import { DatePipe } from "@angular/common";
import { Router } from "@angular/router";

@Component({
  selector: "app-dropdown-product-item",
  templateUrl: "./dropdown-product-item.component.html",
  styleUrls: ["./dropdown-product-item.component.scss"],
  providers: [DatePipe],
})
export class DropdownProductItemComponent implements OnInit {
  @Input() item: any;

  constructor(private _router: Router, private datePipe: DatePipe) {}

  ngOnInit() {}

  getStatus() {
    if (this.item.status === "delivered") {
      return `Arrived ${this.datePipe.transform(
        this.item.estimatedShipDateRange.toDate,
        "longDate"
      )}`;
    } else if (this.item.status === "shipped") {
      return ``;
    } else if (this.item.status === "ordered") {
      return `Expected to ship: ${this.datePipe.transform(
        this.item.estimatedShipDateRange.fromDate,
        "MMM d"
      )} - ${this.datePipe.transform(
        this.item.estimatedShipDateRange.toDate,
        "mediumDate"
      )}`;
    }
  }

  isNewShipDate() {
    return (
      this.item.status === "ordered" &&
      !this.item.userAcceptedDelay &&
      this.item &&
      (this.item.estimatedShipDateRange.fromDate !==
        this.item.newEstimatedShipDateRange.fromDate ||
        this.item.estimatedShipDateRange.toDate !==
          this.item.newEstimatedShipDateRange.toDate)
    );
  }

  navigateTo() {
    this._router.navigate([`details/198772/${this.item.id}`]);
  }
}
