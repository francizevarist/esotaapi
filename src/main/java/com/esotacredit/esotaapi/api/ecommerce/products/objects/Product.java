package com.esotacredit.esotaapi.api.ecommerce.products.objects;

import java.util.List;

public class Product {
    private int productId;
    private String productName;
    private String price;
    private String currencyAbbreviation;
    private int shopId;
    private String shopName;
    private String description;
    private List<Image> images;

    public Product() {}

    public Product(int productId, String productName, String price, String currencyAbbreviation, int shopId, String shopName, String description, List<Image> images) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.currencyAbbreviation = currencyAbbreviation;
        this.shopId = shopId;
        this.shopName = shopName;
        this.description = description;
        this.images = images;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrencyAbbreviation() {
        return currencyAbbreviation;
    }

    public void setCurrencyAbbreviation(String currencyAbbreviation) {
        this.currencyAbbreviation = currencyAbbreviation;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
