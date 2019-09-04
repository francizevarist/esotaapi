package com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpending;

import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpending.objects.Pending;

import java.util.List;

public class PendingResponseBody {
    private List<Pending> pendingList;

    public PendingResponseBody() {}

    public PendingResponseBody(List<Pending> pendingList) {
        this.pendingList = pendingList;
    }

    public List<Pending> getPendingList() {
        return pendingList;
    }

    public void setPendingList(List<Pending> pendingList) {
        this.pendingList = pendingList;
    }
}
