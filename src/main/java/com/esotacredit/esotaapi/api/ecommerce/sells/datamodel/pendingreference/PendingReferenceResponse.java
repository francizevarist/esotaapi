package com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.pendingreference;

import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.pendingreference.objects.PendingReference;

import java.util.List;

public class PendingReferenceResponse {
    List<PendingReference> pendingReferenceList;

    public PendingReferenceResponse() {}

    public PendingReferenceResponse(PendingReferenceResponseBody pendingReferenceList) {
        this.pendingReferenceList = pendingReferenceList.getPendingReferenceList();
    }

    public List<PendingReference> getPendingReferenceList() {
        return pendingReferenceList;
    }
}
