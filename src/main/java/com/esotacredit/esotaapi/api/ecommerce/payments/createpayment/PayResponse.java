package com.esotacredit.esotaapi.api.ecommerce.payments.createpayment;

public class PayResponse {
    PayResponseBody confirmationLink;

    public PayResponse(PayResponseBody payResponseBody) {
        this.confirmationLink = payResponseBody;
    }

    public void setConfirmationLink(PayResponseBody confirmationLink) {
        this.confirmationLink = confirmationLink;
    }

    public PayResponseBody getConfirmationLink() {
        return confirmationLink;
    }
}
