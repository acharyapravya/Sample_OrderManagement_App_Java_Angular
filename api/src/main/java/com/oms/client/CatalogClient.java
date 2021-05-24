package com.oms.client;

import com.oms.model.OrderSummary;
import com.oms.model.SKUDetails;
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
public class CatalogClient {

    private     RestTemplate restTemplate;
    private     Environment  env;
    private     String          baseUrl           = "http://localhost:8090";
    private final static String catalogDetailsUrl = "/catalog/";



    @Autowired
    public CatalogClient(RestTemplate restTemplate, Environment env) {
        this.restTemplate = restTemplate;
        this.env = env;

    }

    public SKUDetails getSKUDetails(String skuId) throws URISyntaxException {

        String url = baseUrl + catalogDetailsUrl +skuId ;
        URI uri = new URI(url);
        HttpHeaders headers = getHeaders();
        return restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), SKUDetails.class).getBody();

    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
