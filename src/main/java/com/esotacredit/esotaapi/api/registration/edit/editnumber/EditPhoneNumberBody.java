package com.esotacredit.esotaapi.api.registration.edit.editnumber;

public class EditPhoneNumberBody {
    private int userId;
    private int countryId;
    private String phoneNumber;

    public EditPhoneNumberBody() {}

    public EditPhoneNumberBody(int userId, int countryId, String phoneNumber) {
        this.userId = userId;
        this.countryId = countryId;
        this.phoneNumber = phoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
