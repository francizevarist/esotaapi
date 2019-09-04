package com.esotacredit.esotaapi.api.ecommerce.payments.createpayment;

public class PayBody {
    private int amount;
    private String referenceNumber;
    private String phoneNumber;

    public PayBody() {}
    public PayBody(int amount, String referenceNumber, String phoneNumber) {
        this.amount = amount;
        this.referenceNumber = referenceNumber;
        this.phoneNumber = phoneNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
