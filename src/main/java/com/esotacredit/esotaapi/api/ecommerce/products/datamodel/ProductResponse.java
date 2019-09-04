package com.esotacredit.esotaapi.api.ecommerce.products.datamodel;

import com.esotacredit.esotaapi.api.ecommerce.products.objects.Network;
import com.esotacredit.esotaapi.api.ecommerce.products.objects.Shop;

public class ProductResponse {

    Network network;
    Shop shop;

    public ProductResponse() {}

    public ProductResponse(ProductResponseBody productResponseBody) {
        this.network = productResponseBody.getNetwork();
        this.shop = productResponseBody.getShop();
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

}
