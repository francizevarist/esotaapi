package com.esotacredit.esotaapi.api.profile.credithistory;

public class CreditBody {
    private int userId;
    private int page;

    public CreditBody() {}

    public CreditBody(int userId) {
        this.userId = userId;
    }

    public CreditBody(int userId, int page) {
        this.userId = userId;
        this.page = page;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
