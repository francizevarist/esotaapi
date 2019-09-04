package com.esotacredit.esotaapi.api.helper.datamodel;

import com.esotacredit.esotaapi.api.helper.datamodel.model.Country;

import java.util.List;

public class CountryResponse {

    List<Country> country;

    public CountryResponse() {}

    public CountryResponse(CountryResponseBody list) {
        this.country = list.getCountryList();
    }

    public List<Country> getCountry() {
        return country;
    }
}
