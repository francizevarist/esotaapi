package com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.warehouse;

import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.warehouse.model.Warehouse;

import java.util.List;

public class WarehouseResponseBody {
    private List<Warehouse> warehouseList;

    public WarehouseResponseBody() {}

    public WarehouseResponseBody(List<Warehouse> warehouseList) {
        this.warehouseList = warehouseList;
    }

    public List<Warehouse> getWarehouseList() {
        return warehouseList;
    }
}
