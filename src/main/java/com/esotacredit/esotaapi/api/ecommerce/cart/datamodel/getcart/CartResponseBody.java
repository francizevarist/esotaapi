package com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.getcart;

import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.getcart.model.Cart;

import java.util.List;

public class CartResponseBody {
    private List<Cart> cartList;

    public CartResponseBody() {
    }

    public CartResponseBody(List<Cart> cartList) {
        this.cartList = cartList;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }
}
