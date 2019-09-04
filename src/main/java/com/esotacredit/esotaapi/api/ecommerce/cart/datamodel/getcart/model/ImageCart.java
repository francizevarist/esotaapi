package com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.getcart.model;

public class ImageCart {

    private int imageId;
    private String imageUrl;

    public ImageCart() {}

    public ImageCart(int imageId, String imageUrl) {
        this.imageId = imageId;
        this.imageUrl = imageUrl;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
