import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { catchError, map, tap } from "rxjs/operators";

@Injectable({
  providedIn: "root",
})
export class OrderDetailsService {
  private _baseURL = "";
  constructor(private _http: HttpClient) {}

  getOrderDetails(orderId: number) {
    return new Promise((resolve, reject) => {
      // this._baseURL + /api/v1/orderstatus/order/${orderId}
      this._http.get("assets/data/order.json").subscribe(async (data: any) => {
        for (let i = 0; i < data.items.length; i++) {
          data.items[i]["details"] = await this.getItemDetails(
            data.items[i].skuId
          );
        }
        resolve(data);
      });
    });
  }

  acceptNewShipDate(orderId: string, itemId: string, payload) {
    payload = {
      ...payload,
      delayAcceptedDate: new Date().toISOString(),
    };

    return this._http.post(
      this._baseURL +
        `/orderactions/acceptShipDate?orderId=${orderId}&itemId=${itemId}`,
      payload
    );
  }

  cancelItem(orderId: string, itemId: string) {
    const payload = {
      cancelReason: "User Cancelled",
      cancelDate: new Date().toISOString(),
    };

    return this._http.post(
      this._baseURL +
        `/orderactions/cancelItem?orderId=${orderId}&itemId=${itemId}`,
      payload
    );
  }

  getItemDetails(skuId: string) {
    return new Promise((resolve, reject) => {
      this._http.get("assets/data/catalog.json").subscribe(
        // this._baseURL + `/catalog/sku/${skuId}`
        (data) => resolve(data),
        (error) => reject(error)
      );
    });
  }
}
