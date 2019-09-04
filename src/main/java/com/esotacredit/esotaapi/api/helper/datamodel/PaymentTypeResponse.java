package com.esotacredit.esotaapi.api.helper.datamodel;

import com.esotacredit.esotaapi.api.helper.datamodel.model.PaymentType;
import com.esotacredit.esotaapi.api.helper.datamodel.object.PaymentList;

import java.util.List;

public class PaymentTypeResponse {
    private List<PaymentType> payment;

    public PaymentTypeResponse() {}

    public PaymentTypeResponse(PaymentTypeResponseBody paymentLists) {
        this.payment = paymentLists.getPaymentTypeList();
    }

    public List<PaymentType> getPayment() {
        return payment;
    }
}
