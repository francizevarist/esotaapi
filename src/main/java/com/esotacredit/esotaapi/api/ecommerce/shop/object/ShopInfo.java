package com.esotacredit.esotaapi.api.ecommerce.shop.object;

public class ShopInfo {
    private int id;
    private String tagLine;
    private String shopName;

    public ShopInfo() {}

    public ShopInfo(int id, String tagLine, String shopName) {
        this.id = id;
        this.tagLine = tagLine;
        this.shopName = shopName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagLine() {
        return tagLine;
    }

    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

}
