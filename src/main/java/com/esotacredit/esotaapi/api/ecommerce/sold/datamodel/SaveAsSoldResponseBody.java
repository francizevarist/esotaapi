package com.esotacredit.esotaapi.api.ecommerce.sold.datamodel;


import com.esotacredit.esotaapi.api.ecommerce.sold.objects.SaveAsSoldResponseMessage;

public class SaveAsSoldResponseBody {

    private SaveAsSoldResponseMessage saveAsSoldResponseMessage;

    public SaveAsSoldResponseBody() {}

    public SaveAsSoldResponseBody(SaveAsSoldResponseMessage saveAsSoldResponseMessage) {
        this.saveAsSoldResponseMessage = saveAsSoldResponseMessage;
    }

    public SaveAsSoldResponseMessage getSaveAsSoldResponseMessage() {
        return saveAsSoldResponseMessage;
    }

    public void setSaveAsSoldResponseMessage(SaveAsSoldResponseMessage saveAsSoldResponseMessage) {
        this.saveAsSoldResponseMessage = saveAsSoldResponseMessage;
    }

}
