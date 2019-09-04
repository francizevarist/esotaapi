package com.esotacredit.esotaapi.api.login.datamodel;

public class LoginResponseBody {

    private int userId;
    private int verificationCode;
    private String countryCode;
    private String phoneNumber;

    public LoginResponseBody() {}

    public LoginResponseBody(int userId, int verificationCode, String countryCode, String phoneNumber) {
        this.userId = userId;
        this.verificationCode = verificationCode;
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(int verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

