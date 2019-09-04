package com.esotacredit.esotaapi.api.ecommerce.searching;

public class SearchingBody {
    private int countryId;
    private String text;

    public SearchingBody() {}

    public SearchingBody(int countryId, String text) {
        this.countryId = countryId;
        this.text = text;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
