package com.esotacredit.esotaapi.api.ecommerce.sold.objects;

public class Sold {
    private int productId;
    private int userId;
    private float sellingPrice;
    private float networkFee;
    private int quantity;

    public Sold() {}

    public Sold(int productId, int userId, float sellingPrice, float networkFee, int quantity) {
        this.productId = productId;
        this.userId = userId;
        this.sellingPrice = sellingPrice;
        this.networkFee = networkFee;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public float getNetworkFee() {
        return networkFee;
    }

    public void setNetworkFee(float networkFee) {
        this.networkFee = networkFee;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
