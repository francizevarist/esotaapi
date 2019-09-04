package com.esotacredit.esotaapi.api.verification.objects;

import java.util.List;

public class Credits {
    private String creditBalance;
    private float progress;

    public Credits() {}

    public Credits(String creditBalance, float progress) {
        this.creditBalance = creditBalance;
        this.progress = progress;
    }

    public String getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(String creditBalance) {
        this.creditBalance = creditBalance;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }
}
