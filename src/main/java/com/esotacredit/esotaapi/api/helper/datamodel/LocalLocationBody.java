package com.esotacredit.esotaapi.api.helper.datamodel;

public class LocalLocationBody {
    private int countryId;
    private String typedName;

    public LocalLocationBody() {
    }

    public LocalLocationBody(int countryId, String typedName) {
        this.countryId = countryId;
        this.typedName = typedName;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getTypedName() {
        return typedName;
    }

    public void setTypedName(String typedName) {
        this.typedName = typedName;
    }
}
