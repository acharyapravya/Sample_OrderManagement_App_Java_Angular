package com.oms.client;

import com.oms.model.OrderSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class OrderSummaryClient {

    private     RestTemplate restTemplate;
    private     Environment  env;
    private     String       baseUrl = "http://localhost:8090";
    private final static String orderSummaryUrl       = "/order/";


    @Autowired
    public OrderSummaryClient(RestTemplate restTemplate, Environment env) {
        this.restTemplate = restTemplate;
        this.env = env;

    }

    public OrderSummary getOrderSummaryByOrderId(Long orderId) throws URISyntaxException {

        String url = baseUrl +orderSummaryUrl+orderId ;
        URI uri = new URI(url);
        HttpHeaders headers = getHeaders();
        return restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), OrderSummary.class).getBody();

    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
