package com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.addtocart;

import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.addtocart.objects.ResponseMessage;

public class AddCartItemResponse {
    private ResponseMessage cart;

    public AddCartItemResponse(AddCartItemResponseBody addCartItemResponseBody) {
        this.cart = addCartItemResponseBody.getMessage();
    }

    public ResponseMessage getCart() {
        return cart;
    }
}
