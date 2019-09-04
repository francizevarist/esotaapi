package com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.purchasedreference;

import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.purchasedreference.objects.PurchasedReference;

import java.util.List;

public class PurchasedReferenceResponseBody {
    private List<PurchasedReference> purchasedReferenceList;

    public PurchasedReferenceResponseBody() {}

    public PurchasedReferenceResponseBody(List<PurchasedReference> purchasedReferenceList) {
        this.purchasedReferenceList = purchasedReferenceList;
    }

    public List<PurchasedReference> getPurchasedReferenceList() {
        return purchasedReferenceList;
    }

    public void setPurchasedReferenceList(List<PurchasedReference> purchasedReferenceList) {
        this.purchasedReferenceList = purchasedReferenceList;
    }


}
