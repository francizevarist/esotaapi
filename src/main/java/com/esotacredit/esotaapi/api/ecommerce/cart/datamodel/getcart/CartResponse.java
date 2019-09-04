package com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.getcart;

import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.getcart.model.Cart;

import java.util.List;
public class CartResponse {
    private List<Cart> cart;

    public CartResponse() {}
    public CartResponse(CartResponseBody cart) {
        this.cart = cart.getCartList();
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }
}
