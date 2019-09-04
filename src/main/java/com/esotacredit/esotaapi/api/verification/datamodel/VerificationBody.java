package com.esotacredit.esotaapi.api.verification.datamodel;

public class VerificationBody {
    private int userId;
    private String verificationCode;

    public VerificationBody() {}

    public VerificationBody(int userId, String verificationCode) {
        this.userId = userId;
        this.verificationCode = verificationCode;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
