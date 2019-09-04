package com.esotacredit.esotaapi.api.ecommerce.products.datamodel;

import com.esotacredit.esotaapi.api.ecommerce.products.objects.Network;
import com.esotacredit.esotaapi.api.ecommerce.products.objects.Shop;

public class ProductResponseBody {

    private Network network;
    private Shop shop;

    public ProductResponseBody() {}

    public ProductResponseBody(Shop shop, Network network) {
        this.network = network;
        this.shop = shop;
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
