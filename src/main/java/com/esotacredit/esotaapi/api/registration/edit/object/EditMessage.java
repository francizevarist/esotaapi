package com.esotacredit.esotaapi.api.registration.edit.object;

public class EditMessage {
    private String message;

    public EditMessage() {}

    public EditMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
