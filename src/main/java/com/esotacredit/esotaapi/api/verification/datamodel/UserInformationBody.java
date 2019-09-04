package com.esotacredit.esotaapi.api.verification.datamodel;

public class UserInformationBody {
    private int userId;

    public UserInformationBody() {}

    public UserInformationBody(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
