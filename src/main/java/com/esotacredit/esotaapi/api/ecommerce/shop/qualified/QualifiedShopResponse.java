package com.esotacredit.esotaapi.api.ecommerce.shop.qualified;

import com.esotacredit.esotaapi.api.ecommerce.shop.object.ShopInfo;

import java.util.List;

public class QualifiedShopResponse {
    private List<ShopInfo> qualifiedShops;

    public QualifiedShopResponse() {}

    public QualifiedShopResponse(QualifiedShopResponseBody qualifiedShops) {
        this.qualifiedShops = qualifiedShops.getShopInfoList();
    }

    public List<ShopInfo> getQualifiedShops() {
        return qualifiedShops;
    }

}
