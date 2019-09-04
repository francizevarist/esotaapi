package com.esotacredit.esotaapi.api.profile.withdraw;

import com.esotacredit.esotaapi.api.profile.withdraw.objects.WithdrawMessage;

public class WithdrawResponseBody {
    WithdrawMessage message;

    public WithdrawResponseBody(WithdrawMessage message) {
        this.message = message;
    }

    public WithdrawMessage getMessage() {
        return message;
    }

    public void setMessage(WithdrawMessage message) {
        this.message = message;
    }
}
