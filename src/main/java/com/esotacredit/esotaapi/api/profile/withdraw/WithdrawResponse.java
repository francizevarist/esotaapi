package com.esotacredit.esotaapi.api.profile.withdraw;

import com.esotacredit.esotaapi.api.profile.withdraw.objects.WithdrawMessage;

public class WithdrawResponse {
    private WithdrawMessage message;

    public WithdrawResponse() {}

    public WithdrawResponse(WithdrawResponseBody message) {
        this.message = message.getMessage();
    }

    public WithdrawMessage getMessage() {
        return message;
    }
}
