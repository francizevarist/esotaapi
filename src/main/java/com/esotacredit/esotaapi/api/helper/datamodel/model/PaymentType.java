package com.esotacredit.esotaapi.api.helper.datamodel.model;

public class PaymentType {
    private int paymentTypeId;
    private String paymentTypeName;
    private String paymentTypeCode;

    public PaymentType() {}

    public PaymentType(int paymentTypeId, String paymentTypeName, String paymentTypeCode) {
        this.paymentTypeId = paymentTypeId;
        this.paymentTypeName = paymentTypeName;
        this.paymentTypeCode = paymentTypeCode;
    }

    public int getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    public String getPaymentTypeCode() {
        return paymentTypeCode;
    }

    public void setPaymentTypeCode(String paymentTypeCode) {
        this.paymentTypeCode = paymentTypeCode;
    }
}
