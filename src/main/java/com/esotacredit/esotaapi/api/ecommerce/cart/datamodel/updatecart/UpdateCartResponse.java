package com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.updatecart;

import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.updatecart.object.ResponseMessage;

public class UpdateCartResponse {
    ResponseMessage updated;

    public UpdateCartResponse() {}

    public UpdateCartResponse(UpdateCartResponseBody updated) {
        this.updated = updated.getMessage();
    }

    public ResponseMessage getUpdated() {
        return updated;
    }
}
