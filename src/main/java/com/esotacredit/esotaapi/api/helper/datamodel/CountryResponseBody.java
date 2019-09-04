package com.esotacredit.esotaapi.api.helper.datamodel;

import com.esotacredit.esotaapi.api.helper.datamodel.model.Country;

import java.util.List;

public class CountryResponseBody {
    private List<Country> countryList;
    public CountryResponseBody() {}

    public CountryResponseBody(List<Country> countryList) {
        this.countryList = countryList;
    }

    public List<Country> getCountryList() {
        return countryList;
    }
}

