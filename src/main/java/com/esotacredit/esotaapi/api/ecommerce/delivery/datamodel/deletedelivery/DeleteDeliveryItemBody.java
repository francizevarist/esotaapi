package com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.deletedelivery;

public class DeleteDeliveryItemBody {
    private int userId;
    private String referenceNumber;

    public DeleteDeliveryItemBody() {}

    public DeleteDeliveryItemBody(int userId, String referenceNumber) {
        this.userId = userId;
        this.referenceNumber = referenceNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

}
