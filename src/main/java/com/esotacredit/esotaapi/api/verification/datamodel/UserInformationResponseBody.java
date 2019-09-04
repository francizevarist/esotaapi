package com.esotacredit.esotaapi.api.verification.datamodel;

import com.esotacredit.esotaapi.api.verification.objects.Network;
import com.esotacredit.esotaapi.api.verification.objects.User;

public class UserInformationResponseBody {

    private User user;
    private Network networkStatus;

    public UserInformationResponseBody() {
    }

    public UserInformationResponseBody(User user, Network networkStatus) {
        this.user = user;
        this.networkStatus = networkStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Network getNetworkStatus() {
        return networkStatus;
    }

    public void setNetworkStatus(Network networkStatus) {
        this.networkStatus = networkStatus;
    }

}
