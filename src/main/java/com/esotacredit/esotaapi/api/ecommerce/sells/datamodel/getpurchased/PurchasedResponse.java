package com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpurchased;

import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpending.PendingResponseBody;
import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpending.objects.Pending;
import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpurchased.objects.Purchased;

import java.util.List;

public class PurchasedResponse {

    List<Purchased> purchasedList;

    public PurchasedResponse() {
    }

    public PurchasedResponse(PurchasedResponseBody purchasedList) {
        this.purchasedList = purchasedList.getPendingList();
    }

    public List<Purchased> getPurchasedList() {
        return purchasedList;
    }
}
