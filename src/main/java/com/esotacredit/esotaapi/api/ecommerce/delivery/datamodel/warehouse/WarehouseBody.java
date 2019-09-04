package com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.warehouse;

public class WarehouseBody {
    private int userId;
    private int locationId;

    public WarehouseBody() {}

    public WarehouseBody(int userId, int locationId) {
        this.userId = userId;
        this.locationId = locationId;
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
}
