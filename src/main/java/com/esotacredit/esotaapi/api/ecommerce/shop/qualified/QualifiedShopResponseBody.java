package com.esotacredit.esotaapi.api.ecommerce.shop.qualified;

import com.esotacredit.esotaapi.api.ecommerce.shop.object.ShopInfo;

import java.util.List;

public class QualifiedShopResponseBody {
    private List<ShopInfo> shopInfoList;

    public QualifiedShopResponseBody() {}

    public QualifiedShopResponseBody(List<ShopInfo> shopInfoList) {
        this.shopInfoList = shopInfoList;
    }

    public List<ShopInfo> getShopInfoList() {
        return shopInfoList;
    }

    public void setShopInfoList(List<ShopInfo> shopInfoList) {
        this.shopInfoList = shopInfoList;
    }

}
