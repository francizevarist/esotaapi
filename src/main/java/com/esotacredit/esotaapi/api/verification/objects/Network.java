package com.esotacredit.esotaapi.api.verification.objects;

public class Network {
    private boolean networkStatus;

    public Network() {}

    public Network(boolean networkStatus) {
        this.networkStatus = networkStatus;
    }

    public boolean isNetworkStatus() {
        return networkStatus;
    }

    public void setNetworkStatus(boolean networkStatus) {
        this.networkStatus = networkStatus;
    }
}
