package com.oms.web;

import com.oms.exception.OrderNotFoundException;
import com.oms.model.ApiResponse;
import com.oms.model.OrderSummary;
import com.oms.model.OrderSummaryResponse;
import com.oms.service.OrderSummaryService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1")
public class OrderStatusControllerV1 {

    @Autowired
    private OrderSummaryService orderSummaryService;

    @GetMapping("orderstatus/order/{orderId}")
    public ResponseEntity<ApiResponse> getOrderStatus(@PathVariable("orderId") Long orderId) {
        OrderSummaryResponse orderSummaryResponse = new OrderSummaryResponse();
        OrderSummary orderSummary = orderSummaryService.getOrderSummary(orderId);
        orderSummaryResponse.setOrderSummary(orderSummary);

        return new ResponseEntity<>(orderSummaryResponse, HttpStatus.OK);
    }
}
