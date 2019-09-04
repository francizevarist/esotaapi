package com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.deletedelivery;

import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.deletedelivery.objects.DeleteDeliveryResponseMessage;

public class DeleteDeliveryItemResponse {
    private DeleteDeliveryResponseMessage deliveryDelete;

    public DeleteDeliveryItemResponse() {}

    public DeleteDeliveryItemResponse(DeleteDeliveryItemResponseBody deliveryDelete) {
        this.deliveryDelete = deliveryDelete.getMessage();
    }

    public DeleteDeliveryResponseMessage getDeliveryDelete() {
        return deliveryDelete;
    }

}
