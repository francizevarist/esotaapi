package com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.warehouse;

import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.warehouse.model.Warehouse;

import java.util.List;

public class WarehouseResponse {
    private List<Warehouse> warehouseList;

    public WarehouseResponse(WarehouseResponseBody warehouseList) {
        this.warehouseList = warehouseList.getWarehouseList();
    }

    public List<Warehouse> getWarehouseList() {
        return warehouseList;
    }
}
