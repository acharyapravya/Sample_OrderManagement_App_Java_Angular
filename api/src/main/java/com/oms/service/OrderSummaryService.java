package com.oms.service;

import com.oms.client.OrderSummaryClient;
import com.oms.exception.OrderNotFoundException;
import com.oms.model.OrderSummary;
import com.oms.model.OrderSummaryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;

@Service
public class OrderSummaryService {

    @Autowired
    private OrderSummaryClient orderSummaryClient;
    private static final Logger  LOG = LoggerFactory.getLogger(OrderSummaryClient.class);
    public OrderSummary getOrderSummary(Long orderId) {

        OrderSummary orderSummary = null;
        try {
            orderSummary = orderSummaryClient.getOrderSummaryByOrderId(orderId);
        } catch (URISyntaxException e) {
            LOG.error("Error Occurred while calling WireMock Stub For Order Details");
        }
        if(orderSummary == null || orderSummary.getOrderId() == null) {
            throw new OrderNotFoundException("Not a Valid OrderId");
        }
        return orderSummary;
    }
}
