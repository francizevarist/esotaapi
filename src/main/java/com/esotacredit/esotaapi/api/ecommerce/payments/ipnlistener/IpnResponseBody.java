package com.esotacredit.esotaapi.api.ecommerce.payments.ipnlistener;

public class IpnResponseBody {
    private boolean resultStatus;

    public IpnResponseBody() {}

    public IpnResponseBody(boolean resultStatus) {
        this.resultStatus = resultStatus;
    }

    public boolean isResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(boolean resultStatus) {
        this.resultStatus = resultStatus;
    }
}
