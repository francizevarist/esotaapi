package com.esotacredit.esotaapi.api.ecommerce.products.objects;

import java.util.List;

public class Shop {
    private  int cartItemsSize;
    private  int soldItemsSize;
    private  int deliveryItemsSize;
    private List<Product> product;

    public Shop() {}

    public Shop(int cartItemsSize, int soldItemsSize, int deliveryItemsSize, List<Product> product) {
        this.cartItemsSize = cartItemsSize;
        this.soldItemsSize = soldItemsSize;
        this.deliveryItemsSize = deliveryItemsSize;
        this.product = product;
    }

    public int getCartItemsSize() {
        return cartItemsSize;
    }

    public void setCartItemsSize(int cartItemsSize) {
        this.cartItemsSize = cartItemsSize;
    }

    public int getSoldItemsSize() {
        return soldItemsSize;
    }

    public void setSoldItemsSize(int soldItemsSize) {
        this.soldItemsSize = soldItemsSize;
    }

    public int getDeliveryItemsSize() {
        return deliveryItemsSize;
    }

    public void setDeliveryItemsSize(int deliveryItemsSize) {
        this.deliveryItemsSize = deliveryItemsSize;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

}
