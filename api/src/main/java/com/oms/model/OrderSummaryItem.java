package com.oms.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OrderSummaryItem implements Serializable {

    private static final long                serialVersionUID = -5718819541536254319L;
    private Long    itemId;
    private String  name;
    private String  planId;
    private String  skuId;
    private Integer quantity;
    private String  telephoneNumber;
    private String  status;
    private Boolean complete;
    private Boolean userAcceptedDelay;
    private String  delayAcceptedDate;

    public OrderSummaryItem() {

    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public Boolean getUserAcceptedDelay() {
        return userAcceptedDelay;
    }

    public void setUserAcceptedDelay(Boolean userAcceptedDelay) {
        this.userAcceptedDelay = userAcceptedDelay;
    }

    public String getDelayAcceptedDate() {
        return delayAcceptedDate;
    }

    public void setDelayAcceptedDate(String delayAcceptedDate) {
        this.delayAcceptedDate = delayAcceptedDate;
    }

}
