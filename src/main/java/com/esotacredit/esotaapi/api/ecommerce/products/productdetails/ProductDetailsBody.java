package com.esotacredit.esotaapi.api.ecommerce.products.productdetails;

public class ProductDetailsBody {
    private int productId;
    private int countryId;

    public ProductDetailsBody() {}
    public ProductDetailsBody(int productId, int countryId) {
        this.productId = productId;
        this.countryId = countryId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
}
