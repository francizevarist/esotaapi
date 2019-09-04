package com.esotacredit.esotaapi.api.verification.objects;

public class Membership {
    private int Id;
    private String purchaseTransactionId;
    private String joiningTime;
    private String creditedTime;
    private String creditedAmount;

    public Membership(int id, String purchaseTransactionId, String joiningTime, String creditedTime, String creditedAmount) {
        Id = id;
        this.purchaseTransactionId = purchaseTransactionId;
        this.joiningTime = joiningTime;
        this.creditedTime = creditedTime;
        this.creditedAmount = creditedAmount;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPurchaseTransactionId() {
        return purchaseTransactionId;
    }

    public void setPurchaseTransactionId(String purchaseTransactionId) {
        this.purchaseTransactionId = purchaseTransactionId;
    }

    public String getJoiningTime() {
        return joiningTime;
    }

    public void setJoiningTime(String joiningTime) {
        this.joiningTime = joiningTime;
    }

    public String getCreditedTime() {
        return creditedTime;
    }

    public void setCreditedTime(String creditedTime) {
        this.creditedTime = creditedTime;
    }

    public String getCreditedAmount() {
        return creditedAmount;
    }

    public void setCreditedAmount(String creditedAmount) {
        this.creditedAmount = creditedAmount;
    }
}
