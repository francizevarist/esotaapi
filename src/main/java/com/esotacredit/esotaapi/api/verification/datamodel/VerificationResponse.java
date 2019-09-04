package com.esotacredit.esotaapi.api.verification.datamodel;

import com.esotacredit.esotaapi.api.verification.objects.Network;
import com.esotacredit.esotaapi.api.verification.objects.User;

public class VerificationResponse {

    User user;
    Network network;

    public VerificationResponse() {}

    public VerificationResponse(VerificationResponseBody verificationResponseBody) {
        this.user = verificationResponseBody.getUser();
        this.network = verificationResponseBody.getNetworkStatus();
    }

    public User getUser() {
        return user;
    }

    public Network getNetwork() {
        return network;
    }

}
