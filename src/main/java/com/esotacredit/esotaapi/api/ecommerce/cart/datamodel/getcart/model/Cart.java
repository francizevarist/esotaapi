package com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.getcart.model;

import java.util.List;

public class Cart {

    private int productId;
    private String productName;
    private String price;
    private int shopId;
    private int quantity;
    private String networkFee;
    private List<ImageCart> imageCarts;

    public Cart() {}

    public Cart(int productId, String productName, String price, int shopId, int quantity, String networkFee, List<ImageCart> imageCarts) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.shopId = shopId;
        this.quantity = quantity;
        this.networkFee = networkFee;
        this.imageCarts = imageCarts;
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

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNetworkFee() {
        return networkFee;
    }

    public void setNetworkFee(String networkFee) {
        this.networkFee = networkFee;
    }

    public List<ImageCart> getImageCarts() {
        return imageCarts;
    }

    public void setImageCarts(List<ImageCart> imageCarts) {
        this.imageCarts = imageCarts;
    }
}
