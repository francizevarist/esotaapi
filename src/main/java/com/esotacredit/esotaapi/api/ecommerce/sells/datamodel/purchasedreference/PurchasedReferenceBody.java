package com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.purchasedreference;

public class PurchasedReferenceBody {
    private int userId;

    public PurchasedReferenceBody() {}
    public PurchasedReferenceBody(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
