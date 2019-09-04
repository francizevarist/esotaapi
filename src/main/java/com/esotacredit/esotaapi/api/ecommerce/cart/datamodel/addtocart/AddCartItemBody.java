package com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.addtocart;

public class AddCartItemBody {
    private int userId;
    private int productId;
    private float sellingPrice;
    private float networkFee;
    private int quantity;

    public AddCartItemBody() {}

    public AddCartItemBody(int userId, int productId, float sellingPrice, float networkFee, int quantity) {
        this.userId = userId;
        this.productId = productId;
        this.sellingPrice = sellingPrice;
        this.networkFee = networkFee;
        this.quantity = quantity;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
