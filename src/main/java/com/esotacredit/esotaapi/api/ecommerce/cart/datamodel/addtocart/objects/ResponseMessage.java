package com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.addtocart.objects;

public class ResponseMessage {
    String message;

    public ResponseMessage() {}
    public ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
