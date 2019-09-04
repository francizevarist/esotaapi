package com.esotacredit.esotaapi.api.verification.objects;

public class User {

    private int userId;
    private String userFullName;
    private int countryId;
    private String countryCode;
    private String countryName;
    private String currencyName;
    private String currencyAbbreviation;
    private String phoneNumber;
    private Credits credits;

    public User() {}

    public User(int userId, String userFullName, int countryId, String countryCode, String countryName, String currencyName, String currencyAbbreviation, String phoneNumber, Credits credits) {
        this.userId = userId;
        this.userFullName = userFullName;
        this.countryId = countryId;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.currencyName = currencyName;
        this.currencyAbbreviation = currencyAbbreviation;
        this.phoneNumber = phoneNumber;
        this.credits = credits;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyAbbreviation() {
        return currencyAbbreviation;
    }

    public void setCurrencyAbbreviation(String currencyAbbreviation) {
        this.currencyAbbreviation = currencyAbbreviation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Credits getCredits() {
        return credits;
    }

    public void setCredits(Credits credits) {
        this.credits = credits;
    }


}
