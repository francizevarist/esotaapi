package com.esotacredit.esotaapi.api.ecommerce.products.datamodel;

public class ProductBody {

    private int userId;
    private int countryId;
    private int page;

    public ProductBody() {}

    public ProductBody(int userId, int countryId, int page) {
        this.userId = userId;
        this.countryId = countryId;
        this.page = page;
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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
