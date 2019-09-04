package com.esotacredit.esotaapi.api.helper.datamodel;

import com.esotacredit.esotaapi.api.helper.datamodel.model.LocalLocation;

import java.util.List;

public class LocalLocationResponseBody {
    List<LocalLocation> localLocationList;

    public LocalLocationResponseBody() {}

    public LocalLocationResponseBody(List<LocalLocation> localLocationList) {
        this.localLocationList = localLocationList;
    }

    public List<LocalLocation> getLocalLocationList() {
        return localLocationList;
    }

    public void setLocalLocationList(List<LocalLocation> localLocationList) {
        this.localLocationList = localLocationList;
    }

}
