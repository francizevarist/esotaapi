package com.esotacredit.esotaapi.api.ecommerce.shop.qualified;

public class QualifiedShopBody {
    private int countryId;

    public QualifiedShopBody() {
    }

    public QualifiedShopBody(int countryId) {
        this.countryId = countryId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
}
