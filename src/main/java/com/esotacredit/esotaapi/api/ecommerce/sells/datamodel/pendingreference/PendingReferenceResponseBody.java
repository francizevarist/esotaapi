package com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.pendingreference;

import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.pendingreference.objects.PendingReference;

import java.util.List;

public class PendingReferenceResponseBody {
    private List<PendingReference> pendingReferenceList;

    public PendingReferenceResponseBody() {}

    public PendingReferenceResponseBody(List<PendingReference> pendingReferenceList) {
        this.pendingReferenceList = pendingReferenceList;
    }

    public List<PendingReference> getPendingReferenceList() {
        return pendingReferenceList;
    }

    public void setPendingReferenceList(List<PendingReference> pendingReferenceList) {
        this.pendingReferenceList = pendingReferenceList;
    }

}
