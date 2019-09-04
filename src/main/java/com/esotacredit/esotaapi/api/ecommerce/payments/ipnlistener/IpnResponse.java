package com.esotacredit.esotaapi.api.ecommerce.payments.ipnlistener;

public class IpnResponse {
    private IpnResponseBody IpnStatus;

    public IpnResponse(IpnResponseBody resultStatus) {
        this.IpnStatus = resultStatus;
    }

    public IpnResponseBody getIpnStatus() {
        return IpnStatus;
    }
}
