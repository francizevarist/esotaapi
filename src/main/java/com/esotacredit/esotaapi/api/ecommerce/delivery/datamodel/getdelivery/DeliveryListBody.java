package com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.getdelivery;

public class DeliveryListBody {
    private int userId;

    public DeliveryListBody() {
    }
    public DeliveryListBody(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
