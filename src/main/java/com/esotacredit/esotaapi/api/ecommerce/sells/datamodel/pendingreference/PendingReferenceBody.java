package com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.pendingreference;

public class PendingReferenceBody {
    private int userId;

    public PendingReferenceBody() {}

    public PendingReferenceBody(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
