package com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.pendingreference.objects;

import com.esotacredit.esotaapi.api.ecommerce.payments.PaymentState;

public class PendingReference {

    private String referenceNumber;
    private String createdTime;
    private float  totalAmount;
    private PaymentState paymentStatus;
    private int quantity;

    public PendingReference() {}

    public PendingReference(String referenceNumber, String createdTime, float totalAmount, PaymentState paymentStatus, int quantity) {
        this.referenceNumber = referenceNumber;
        this.createdTime = createdTime;
        this.totalAmount = totalAmount;
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

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
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
