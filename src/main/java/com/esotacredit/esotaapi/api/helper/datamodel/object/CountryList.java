package com.esotacredit.esotaapi.api.helper.datamodel.object;

import com.esotacredit.esotaapi.api.helper.datamodel.model.Country;

import java.util.List;

public class CountryList {
    private List<Country> countryList;

    public CountryList() {}

    public CountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public List<Country> getCountryList() {
        return countryList;
    }
}
