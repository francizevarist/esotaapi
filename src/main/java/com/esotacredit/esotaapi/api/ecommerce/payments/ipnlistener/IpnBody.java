package com.esotacredit.esotaapi.api.ecommerce.payments.ipnlistener;

public class IpnBody {
    private String notificationType;
    private String transactionId;
    private String referenceNumber;

    public IpnBody() {}

    public IpnBody(String notificationType, String transactionId, String referenceNumber) {
        this.notificationType = notificationType;
        this.transactionId = transactionId;
        this.referenceNumber = referenceNumber;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
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
