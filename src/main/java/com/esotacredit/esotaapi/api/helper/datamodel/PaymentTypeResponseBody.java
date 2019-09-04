package com.esotacredit.esotaapi.api.helper.datamodel;

import com.esotacredit.esotaapi.api.helper.datamodel.model.PaymentType;
import com.esotacredit.esotaapi.api.helper.datamodel.object.PaymentList;

import java.util.List;

public class PaymentTypeResponseBody {
    private List<PaymentType> paymentTypeList;

    public PaymentTypeResponseBody() {}

    public PaymentTypeResponseBody(List<PaymentType> paymentTypeList) {
        this.paymentTypeList = paymentTypeList;
    }

    public List<PaymentType> getPaymentTypeList() {
        return paymentTypeList;
    }

    public void setPaymentTypeList(List<PaymentType> paymentTypeList) {
        this.paymentTypeList = paymentTypeList;
    }

}
