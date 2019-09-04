package com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.deletecart;

import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.addtocart.AddCartItemResponseBody;
import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.addtocart.objects.ResponseMessage;

public class DeleteCartItemResponse {

    private ResponseMessage deleted;

    public DeleteCartItemResponse(DeleteCartItemResponseBody deleteCartItemBody) {
        this.deleted = deleteCartItemBody.getMessage();
    }

    public ResponseMessage getDeleted() {
        return deleted;
    }
}
