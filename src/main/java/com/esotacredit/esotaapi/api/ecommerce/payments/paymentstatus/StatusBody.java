package com.esotacredit.esotaapi.api.ecommerce.payments.paymentstatus;

public class StatusBody {
    private String transactionId;
    private String referenceNumber;

    public StatusBody() {}

    public StatusBody(String transactionId, String referenceNumber) {
        this.transactionId = transactionId;
        this.referenceNumber = referenceNumber;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

}
