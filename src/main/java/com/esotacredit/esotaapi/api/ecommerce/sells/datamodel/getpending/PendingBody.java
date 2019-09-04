package com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpending;

public class PendingBody {
    private int userId;
    private String referenceNumber;

    public PendingBody() {}

    public PendingBody(int userId, String referenceNumber) {
        this.userId = userId;
        this.referenceNumber = referenceNumber;
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

}
