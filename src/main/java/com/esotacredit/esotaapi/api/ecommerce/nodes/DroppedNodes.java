package com.esotacredit.esotaapi.api.ecommerce.nodes;

public class DroppedNodes {

    int networkId;
    int userId;
    int base;
    int state;

    public DroppedNodes() {}

    public DroppedNodes(int networkId, int userId, int base, int state) {
        this.networkId = networkId;
        this.userId = userId;
        this.base = base;
        this.state = state;
    }

    public int getNetworkId() {
        return networkId;
    }

    public void setNetworkId(int networkId) {
        this.networkId = networkId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
