package com.esotacredit.esotaapi.api.registration.edit.editnumber;

import com.esotacredit.esotaapi.api.registration.edit.object.EditMessage;

public class EditPhoneNumberResponseBody {
    private EditMessage message;

    public EditPhoneNumberResponseBody(EditMessage message) {
        this.message = message;
    }

    public EditMessage getMessage() {
        return message;
    }

    public void setMessage(EditMessage message) {
        this.message = message;
    }
}
