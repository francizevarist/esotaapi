package com.esotacredit.esotaapi.api.profile.withdraw;

public class WithdrawBody {
    private int userId;
    private float amount;

    public WithdrawBody() {}

    public WithdrawBody(int userId, float amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
