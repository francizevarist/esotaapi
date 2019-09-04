package com.esotacredit.esotaapi.api.profile.credithistory;

import com.esotacredit.esotaapi.api.profile.credithistory.object.Credit;

import java.util.List;

public class CreditResponseBody {
    private List<Credit> creditList;

    public CreditResponseBody() {}

    public CreditResponseBody(List<Credit> creditList) {
        this.creditList = creditList;
    }

    public List<Credit> getCreditList() {
        return creditList;
    }

    public void setCreditList(List<Credit> creditList) {
        this.creditList = creditList;
    }

}
