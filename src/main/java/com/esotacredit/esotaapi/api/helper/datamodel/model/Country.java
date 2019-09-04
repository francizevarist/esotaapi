package com.esotacredit.esotaapi.api.helper.datamodel.model;

public class Country {
    private int countryId;
    private String countryName;
    private String countryCode;
    private String currencyId;

    public Country() {}

    public Country(int countryId, String countryName, String countryCode, String currencyId) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.currencyId = currencyId;
    }

    public int getCountryId() {
        return countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCurrencyId() {
        return currencyId;
    }
}
