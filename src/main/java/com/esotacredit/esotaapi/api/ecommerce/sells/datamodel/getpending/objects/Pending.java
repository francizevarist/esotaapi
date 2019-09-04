package com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpending.objects;

import com.esotacredit.esotaapi.api.ecommerce.payments.PaymentState;

public class Pending {

    private int productId;
    private String productName;
    private int shopId;
    private String shopName;
    private String sellingPrice;
    private String feeAmount;
    private String referenceNumber;
    private String paymentDateAndTime;
    private PaymentState paymentStatus;

    public Pending() {}

    public Pending(int productId, String productName, int shopId, String shopName, String sellingPrice, String feeAmount, String referenceNumber, String paymentDateAndTime, PaymentState paymentStatus) {
        this.productId = productId;
        this.productName = productName;
        this.shopId = shopId;
        this.shopName = shopName;
        this.sellingPrice = sellingPrice;
        this.feeAmount = feeAmount;
        this.referenceNumber = referenceNumber;
        this.paymentDateAndTime = paymentDateAndTime;
        this.paymentStatus = paymentStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(String feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getPaymentDateAndTime() {
        return paymentDateAndTime;
    }

    public void setPaymentDateAndTime(String paymentDateAndTime) {
        this.paymentDateAndTime = paymentDateAndTime;
    }

    public PaymentState getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentState paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
