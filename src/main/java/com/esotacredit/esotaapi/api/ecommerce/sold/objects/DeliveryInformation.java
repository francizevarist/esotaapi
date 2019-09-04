package com.esotacredit.esotaapi.api.ecommerce.sold.objects;

public class DeliveryInformation {
    private int userId;
    private int locationId;
    private String addressNote;
    private int paymentTypeId;
    private int paymentTypeCode;
    private float deliveryFee;

    public DeliveryInformation() {}
    public DeliveryInformation(int userId, int locationId, String addressNote, int paymentTypeId, int paymentTypeCode, float deliveryFee) {
        this.userId = userId;
        this.locationId = locationId;
        this.addressNote = addressNote;
        this.paymentTypeId = paymentTypeId;
        this.paymentTypeCode = paymentTypeCode;
        this.deliveryFee = deliveryFee;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getAddressNote() {
        return addressNote;
    }

    public void setAddressNote(String addressNote) {
        this.addressNote = addressNote;
    }

    public int getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public int getPaymentTypeCode() {
        return paymentTypeCode;
    }

    public void setPaymentTypeCode(int paymentTypeCode) {
        this.paymentTypeCode = paymentTypeCode;
    }

    public float getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(float deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

}
