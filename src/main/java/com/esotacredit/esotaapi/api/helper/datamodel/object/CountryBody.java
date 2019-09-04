package com.esotacredit.esotaapi.api.helper.datamodel.object;

public class CountryBody {
    private String countryName;

    public CountryBody() {}

    public CountryBody(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
