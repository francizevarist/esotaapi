package com.esotacredit.esotaapi.api.ecommerce.payments.paymentstatus;

public class StatusResponse {
    private StatusResponseBody paymentStatus;

    public StatusResponse() {}

    public StatusResponse(StatusResponseBody paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public StatusResponseBody getPaymentStatus() {
        return paymentStatus;
    }
}
