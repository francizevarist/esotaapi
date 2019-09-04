package com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.getdeliveryproduct;

import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.getdeliveryproduct.model.DeliveryProduct;

import java.util.List;

public class DeliveryProductResponseBody {
    private List<DeliveryProduct> deliveryProductList;

    public DeliveryProductResponseBody() {}

    public DeliveryProductResponseBody(List<DeliveryProduct> deliveryProductList) {
        this.deliveryProductList = deliveryProductList;
    }

    public List<DeliveryProduct> getDeliveryProductList() {
        return deliveryProductList;
    }

    public void setDeliveryProductList(List<DeliveryProduct> deliveryProductList) {
        this.deliveryProductList = deliveryProductList;
    }
}
