package com.esotacredit.esotaapi.api.verification.objects;

public class NextCredit {
    String date;
    float nextCredit;

    public NextCredit() {}
    public NextCredit(String date, float nextCredit) {
        this.date = date;
        this.nextCredit = nextCredit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getNextCredit() {
        return nextCredit;
    }

    public void setNextCredit(float nextCredit) {
        this.nextCredit = nextCredit;
    }
}
