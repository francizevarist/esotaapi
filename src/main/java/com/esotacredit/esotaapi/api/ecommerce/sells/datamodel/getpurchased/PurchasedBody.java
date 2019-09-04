package com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpurchased;

public class PurchasedBody {

    private int userId;
    private String referenceNumber;
    private String paymentDateAndTime;
    private int page;

    public PurchasedBody() {}

    public PurchasedBody(int userId) {
        this.userId = userId;
    }

    public PurchasedBody(int userId, int page) {
        this.userId = userId;
        this.page = page;
    }

    public PurchasedBody(int userId, String referenceNumber, String paymentDateAndTime, int page) {
        this.userId = userId;
        this.referenceNumber = referenceNumber;
        this.paymentDateAndTime = paymentDateAndTime;
        this.page = page;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

}
