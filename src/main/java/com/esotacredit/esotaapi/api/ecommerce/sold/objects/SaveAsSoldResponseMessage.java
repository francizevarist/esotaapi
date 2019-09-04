package com.esotacredit.esotaapi.api.ecommerce.sold.objects;

public class SaveAsSoldResponseMessage {

    String message;
    public SaveAsSoldResponseMessage() {}

    public SaveAsSoldResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
