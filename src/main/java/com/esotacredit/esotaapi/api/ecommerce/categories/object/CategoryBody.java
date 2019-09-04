package com.esotacredit.esotaapi.api.ecommerce.categories.object;

public class CategoryBody {
    private int countryId;


    public CategoryBody() {}
    public CategoryBody(int countryId) {
        this.countryId = countryId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
}
