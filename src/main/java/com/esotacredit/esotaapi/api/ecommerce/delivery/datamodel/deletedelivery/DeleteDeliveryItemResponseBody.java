package com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.deletedelivery;

import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.deletedelivery.objects.DeleteDeliveryResponseMessage;

public class DeleteDeliveryItemResponseBody {
    DeleteDeliveryResponseMessage message;

    public DeleteDeliveryItemResponseBody() {}

    public DeleteDeliveryItemResponseBody(DeleteDeliveryResponseMessage message) {
        this.message = message;
    }

    public DeleteDeliveryResponseMessage getMessage() {
        return message;
    }

    public void setMessage(DeleteDeliveryResponseMessage message) {
        this.message = message;
    }
}
