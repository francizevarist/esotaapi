package com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.updatecart.model;

public class CartProduct {
    private int cartId;
    private int productId;
    private int userId;
    private int quantity;

    public CartProduct() {}

    public CartProduct(int cartId, int productId, int userId, int quantity) {
        this.cartId = cartId;
        this.productId = productId;
        this.userId = userId;
        this.quantity = quantity;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
