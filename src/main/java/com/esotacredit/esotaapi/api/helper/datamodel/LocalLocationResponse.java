package com.esotacredit.esotaapi.api.helper.datamodel;

import com.esotacredit.esotaapi.api.helper.datamodel.model.LocalLocation;

import java.util.List;

public class LocalLocationResponse {

    List<LocalLocation> localLocations;

    public LocalLocationResponse() {
    }

    public LocalLocationResponse(LocalLocationResponseBody locationResponseBody) {
        this.localLocations = locationResponseBody.getLocalLocationList();
    }

    public List<LocalLocation> getLocalLocations() {
        return localLocations;
    }
}
