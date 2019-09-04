package com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.getdelivery.model;

import com.esotacredit.esotaapi.api.ecommerce.payments.PaymentState;

public class Delivery {

    private int userId;
    private String ReferenceNumber;
    private String createdTime;
    private PaymentState paymentStatus;
    private String paymentTime;
    private int paymentTypeId;
    private int paymentTypeCode;
    private int deliveryStatus;
    private int deliveryState;
    private int deliveryNumber;
    private String locationName;
    private String address_note;
    private String deliveryFee;
    private String deliveryTime;
    private String totalSellingPrice;
    private String serviceFee;
    private int quantity;

    public Delivery() {}

    public Delivery(int userId, String referenceNumber, String createdTime, PaymentState paymentStatus, String paymentTime, int paymentTypeId, int paymentTypeCode, int deliveryStatus, int deliveryState, int deliveryNumber, String locationName, String address_note, String deliveryFee, String deliveryTime, String totalSellingPrice, String serviceFee, int quantity) {
        this.userId = userId;
        ReferenceNumber = referenceNumber;
        this.createdTime = createdTime;
        this.paymentStatus = paymentStatus;
        this.paymentTime = paymentTime;
        this.paymentTypeId = paymentTypeId;
        this.paymentTypeCode = paymentTypeCode;
        this.deliveryStatus = deliveryStatus;
        this.deliveryState = deliveryState;
        this.deliveryNumber = deliveryNumber;
        this.locationName = locationName;
        this.address_note = address_note;
        this.deliveryFee = deliveryFee;
        this.deliveryTime = deliveryTime;
        this.totalSellingPrice = totalSellingPrice;
        this.serviceFee = serviceFee;
        this.quantity = quantity;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getReferenceNumber() {
        return ReferenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        ReferenceNumber = referenceNumber;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public PaymentState getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentState paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
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

    public int getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(int deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public int getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(int deliveryState) {
        this.deliveryState = deliveryState;
    }

    public int getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(int deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getAddress_note() {
        return address_note;
    }

    public void setAddress_note(String address_note) {
        this.address_note = address_note;
    }

    public String getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(String deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getTotalSellingPrice() {
        return totalSellingPrice;
    }

    public void setTotalSellingPrice(String totalSellingPrice) {
        this.totalSellingPrice = totalSellingPrice;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
