package com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.getdeliveryproduct.model;

public class DeliveryProduct {
    private int productId;
    private String productName;
    private String productImageUrl;

    public DeliveryProduct() {}
    public DeliveryProduct(int productId, String productName, String productImageUrl) {
        this.productId = productId;
        this.productName = productName;
        this.productImageUrl = productImageUrl;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

}
