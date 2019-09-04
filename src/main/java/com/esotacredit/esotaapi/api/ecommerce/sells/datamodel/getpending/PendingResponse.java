package com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpending;

import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpending.objects.Pending;

import java.util.List;

public class PendingResponse {
    List<Pending> pendingList;

    public PendingResponse() {
    }

    public PendingResponse(PendingResponseBody pendingList) {
        this.pendingList = pendingList.getPendingList();
    }

    public List<Pending> getPendingList() {
        return pendingList;
    }
}
