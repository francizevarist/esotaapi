package com.esotacredit.esotaapi.api.helper.datamodel.model;

public class LocalLocation {
    private int locationId;
    private String locationName;
    private int countryId;
    private String deliveryTime;
    private String deliveryFee;

    public LocalLocation() {}

    public LocalLocation(int locationId, String locationName, int countryId, String deliveryTime, String deliveryFee) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.countryId = countryId;
        this.deliveryTime = deliveryTime;
        this.deliveryFee = deliveryFee;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(String deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

}
