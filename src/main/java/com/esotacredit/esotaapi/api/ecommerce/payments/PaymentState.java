package com.esotacredit.esotaapi.api.ecommerce.payments;

public class PaymentState {
    private boolean status;
    private String message;

    public PaymentState() {}

    public PaymentState(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
