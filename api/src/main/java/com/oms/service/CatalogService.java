package com.oms.service;

import com.oms.client.CatalogClient;
import com.oms.model.OrderSummary;
import com.oms.model.SKU;
import com.oms.model.SKUDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;

@Service
public class CatalogService {

    @Autowired
    private CatalogClient catalogClient;

    public SKUDetails getSku(String skuId) throws URISyntaxException {
        SKUDetails skuDetails = catalogClient.getSKUDetails(skuId);
        return skuDetails;
    }
}
