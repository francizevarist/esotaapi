package com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.addtocart;
import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.addtocart.objects.ResponseMessage;

public class AddCartItemResponseBody {
    ResponseMessage message;

    public AddCartItemResponseBody() {}

    public AddCartItemResponseBody(ResponseMessage message) {
        this.message = message;
    }

    public ResponseMessage getMessage() {
        return message;
    }

    public void setMessage(ResponseMessage message) {
        this.message = message;
    }

}
