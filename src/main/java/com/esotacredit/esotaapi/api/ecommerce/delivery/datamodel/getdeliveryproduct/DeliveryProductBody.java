package com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.getdeliveryproduct;

public class DeliveryProductBody {
    private int userId;
    private String referenceNumber;

    public DeliveryProductBody() {}

    public DeliveryProductBody(int userId, String referenceNumber) {
        this.userId = userId;
        this.referenceNumber = referenceNumber;
    }

    public int getUserId() {
        return userId;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }
}
