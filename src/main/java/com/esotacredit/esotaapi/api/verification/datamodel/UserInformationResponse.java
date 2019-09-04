package com.esotacredit.esotaapi.api.verification.datamodel;

import com.esotacredit.esotaapi.api.verification.objects.Network;
import com.esotacredit.esotaapi.api.verification.objects.User;

public class UserInformationResponse {
    User user;
    Network network;

    public UserInformationResponse() {}

    public UserInformationResponse(UserInformationResponseBody userInformationBody) {
        this.user = userInformationBody.getUser();
        this.network = userInformationBody.getNetworkStatus();
    }

    public User getUser() {
        return user;
    }

    public Network getNetwork() {
        return network;
    }
}
