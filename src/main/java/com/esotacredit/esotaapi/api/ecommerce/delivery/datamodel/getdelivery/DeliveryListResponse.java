package com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.getdelivery;

import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.getdelivery.model.Delivery;

import java.util.List;

public class DeliveryListResponse {
    List<Delivery> deliveries;

    public DeliveryListResponse() {}

    public DeliveryListResponse(DeliveryListResponseBody deliveries) {
        this.deliveries = deliveries.getDeliveryList();
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }
}
