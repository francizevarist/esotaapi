package com.esotacredit.esotaapi.api.ecommerce.sold.datamodel;

import com.esotacredit.esotaapi.api.ecommerce.sold.objects.SaveAsSoldResponseMessage;

public class SaveAsSoldResponse {
    private SaveAsSoldResponseMessage message;

    public SaveAsSoldResponse() {}

    public SaveAsSoldResponse(SaveAsSoldResponseBody message) {
        this.message = message.getSaveAsSoldResponseMessage();
    }

    public SaveAsSoldResponseMessage getMessage() {
        return message;
    }
}
