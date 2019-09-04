package com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.updatecart;

import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.updatecart.object.ResponseMessage;

public class UpdateCartResponseBody {
    ResponseMessage message;

    public UpdateCartResponseBody() {}

    public UpdateCartResponseBody(ResponseMessage message) {
        this.message = message;
    }

    public ResponseMessage getMessage() {
        return message;
    }

    public void setMessage(ResponseMessage message) {
        this.message = message;
    }
}
