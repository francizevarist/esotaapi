package com.esotacredit.esotaapi.api.helper.datamodel.object;

import com.esotacredit.esotaapi.api.helper.datamodel.model.PaymentType;

import java.util.List;

public class PaymentList {
    private List<PaymentType> paymentTypeList;

    public PaymentList() {}

    public PaymentList(List<PaymentType> paymentTypeList) {
        this.paymentTypeList = paymentTypeList;
    }

    public List<PaymentType> getPaymentTypeList() {
        return paymentTypeList;
    }

    public void setPaymentTypeList(List<PaymentType> paymentTypeList) {
        this.paymentTypeList = paymentTypeList;
    }
}
