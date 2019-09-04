package com.esotacredit.esotaapi.api.ecommerce.products.datamodel;

public class RelatedProductBody {
    private int userId;
    private int countryId;
    private int productId;
    private int page;

    public RelatedProductBody() {}

    public RelatedProductBody(int userId, int countryId, int productId, int page) {
        this.userId = userId;
        this.countryId = countryId;
        this.productId = productId;
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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
