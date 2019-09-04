package com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpurchased;

import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpending.objects.Pending;
import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpurchased.objects.Purchased;

import java.util.List;

public class PurchasedResponseBody {

    private List<Purchased> pendingList;

    public PurchasedResponseBody() {}

    public PurchasedResponseBody(List<Purchased> pendingList) {
        this.pendingList = pendingList;
    }

    public List<Purchased> getPendingList() {
        return pendingList;
    }

    public void setPendingList(List<Purchased> pendingList) {
        this.pendingList = pendingList;
    }

}
