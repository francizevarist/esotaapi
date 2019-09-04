package com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.purchasedreference.objects;

import com.esotacredit.esotaapi.api.ecommerce.payments.PaymentState;

public class PurchasedReference {
    private String referenceNumber;
    private String createdTime;
    private String deliveryFee;
    private String totalSellingPrice;
    private String serviceFee;
    private PaymentState paymentStatus;
    private int quantity;

    public PurchasedReference() {}

    public PurchasedReference(String referenceNumber, String createdTime, String deliveryFee, String totalSellingPrice, String serviceFee, PaymentState paymentStatus, int quantity) {
        this.referenceNumber = referenceNumber;
        this.createdTime = createdTime;
        this.deliveryFee = deliveryFee;
        this.totalSellingPrice = totalSellingPrice;
        this.serviceFee = serviceFee;
        this.paymentStatus = paymentStatus;
        this.quantity = quantity;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(String deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public String getTotalSellingPrice() {
        return totalSellingPrice;
    }

    public void setTotalSellingPrice(String totalSellingPrice) {
        this.totalSellingPrice = totalSellingPrice;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public PaymentState getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentState paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
