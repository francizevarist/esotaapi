package com.esotacredit.esotaapi.api.profile.credithistory;

import com.esotacredit.esotaapi.api.profile.credithistory.object.Credit;

import java.util.List;

public class CreditResponse {
    private List<Credit> creditList;

    public CreditResponse() {}

    public CreditResponse(CreditResponseBody creditResponseBody) {
        this.creditList = creditResponseBody.getCreditList();
    }

    public List<Credit> getCreditList() {
        return creditList;
    }

}
