package com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.deletecart;

import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.addtocart.objects.ResponseMessage;

public class DeleteCartItemResponseBody {

    ResponseMessage message;

    public DeleteCartItemResponseBody() {}

    public DeleteCartItemResponseBody(ResponseMessage message) {
        this.message = message;
    }

    public ResponseMessage getMessage() {
        return message;
    }

    public void setMessage(ResponseMessage message) {
        this.message = message;
    }

}
