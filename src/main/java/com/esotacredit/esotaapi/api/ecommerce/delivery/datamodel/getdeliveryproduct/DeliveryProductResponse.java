package com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.getdeliveryproduct;

import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.getdeliveryproduct.model.DeliveryProduct;

import java.util.List;

public class DeliveryProductResponse {
    private List<DeliveryProduct> productList;

    public DeliveryProductResponse(DeliveryProductResponseBody productList) {
        this.productList = productList.getDeliveryProductList();
    }

    public List<DeliveryProduct> getProductList() {
        return productList;
    }
}
