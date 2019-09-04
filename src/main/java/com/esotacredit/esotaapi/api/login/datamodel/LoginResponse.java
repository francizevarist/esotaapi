package com.esotacredit.esotaapi.api.login.datamodel;

public class LoginResponse {

    LoginResponseBody login;
    public LoginResponse() {}
    public LoginResponse(LoginResponseBody loginResponseBody) {
        this.login = loginResponseBody;
    }

    public LoginResponseBody getLogin() {
        return login;
    }

}
