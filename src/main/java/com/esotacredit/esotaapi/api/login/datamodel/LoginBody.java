package com.esotacredit.esotaapi.api.login.datamodel;

public class LoginBody {

    private int countryId;
    private String phoneNumber;

    public LoginBody() {}

    public LoginBody(int countryId, String phoneNumber) {
        this.countryId = countryId;
        this.phoneNumber = phoneNumber;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
