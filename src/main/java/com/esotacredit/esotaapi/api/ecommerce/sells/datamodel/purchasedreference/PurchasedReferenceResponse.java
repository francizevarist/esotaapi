package com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.purchasedreference;

import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.purchasedreference.objects.PurchasedReference;

import java.util.List;

public class PurchasedReferenceResponse {
    List<PurchasedReference> purchasedReferenceList;

    public PurchasedReferenceResponse() {}

    public PurchasedReferenceResponse(PurchasedReferenceResponseBody purchasedReferenceList) {
        this.purchasedReferenceList = purchasedReferenceList.getPurchasedReferenceList();
    }

    public List<PurchasedReference> getPurchasedReferenceList() {
        return purchasedReferenceList;
    }
}
