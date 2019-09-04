package com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.warehouse.model;

public class Warehouse {
    private int warehouseId;
    private String warehouseName;
    private String warehouseLocation;
    private String warehouseAddress;

    public Warehouse() {}

    public Warehouse(int warehouseId, String warehouseName, String warehouseLocation, String warehouseAddress) {
        this.warehouseId = warehouseId;
        this.warehouseName = warehouseName;
        this.warehouseLocation = warehouseLocation;
        this.warehouseAddress = warehouseAddress;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseLocation() {
        return warehouseLocation;
    }

    public void setWarehouseLocation(String warehouseLocation) {
        this.warehouseLocation = warehouseLocation;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }
}
