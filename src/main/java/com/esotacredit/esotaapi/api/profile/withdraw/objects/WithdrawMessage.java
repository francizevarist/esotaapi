package com.esotacredit.esotaapi.api.profile.withdraw.objects;

public class WithdrawMessage {
    private String message;

    public WithdrawMessage() {}

    public WithdrawMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
