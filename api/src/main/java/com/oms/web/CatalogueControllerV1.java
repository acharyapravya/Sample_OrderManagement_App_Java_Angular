package com.oms.web;

import com.oms.model.OrderSummaryResponse;
import com.oms.model.SKU;
import com.oms.model.SKUDetails;
import com.oms.service.CatalogService;
import com.oms.service.OrderSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CatalogueControllerV1 {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("catalog/sku/{skuId}")
    public ResponseEntity<SKUDetails> getSKU(@PathVariable("skuId") String skuId) throws Exception {
        SKUDetails skuDetails = new SKUDetails();
        skuDetails = catalogService.getSku(skuId);
        return new ResponseEntity<>(skuDetails, HttpStatus.OK);
    }
}
