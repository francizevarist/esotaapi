package com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.getdelivery;

import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.getdelivery.model.Delivery;

import java.util.List;

public class DeliveryListResponseBody {
    List<Delivery> deliveryList;

    public DeliveryListResponseBody() {}

    public DeliveryListResponseBody(List<Delivery> deliveryList) {
        this.deliveryList = deliveryList;
    }

    public List<Delivery> getDeliveryList() {
        return deliveryList;
    }

    public void setDeliveryList(List<Delivery> deliveryList) {
        this.deliveryList = deliveryList;
    }

}
