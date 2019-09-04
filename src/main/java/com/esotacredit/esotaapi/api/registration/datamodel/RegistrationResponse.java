package com.esotacredit.esotaapi.api.registration.datamodel;

public class RegistrationResponse {

    private RegistrationResponseBody registered;

    public RegistrationResponse() {}

    public RegistrationResponse(RegistrationResponseBody registered) {
        this.registered = registered;
    }

    public RegistrationResponseBody getRegistered() {
        return registered;
    }
}
