package com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.getcart;

public class CartBody {
    private int userId;

    public CartBody() {}

    public CartBody(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
