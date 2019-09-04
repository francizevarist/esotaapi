package com.esotacredit.esotaapi.api.registration.edit.editnumber;

import com.esotacredit.esotaapi.api.registration.edit.object.EditMessage;

public class EditPhoneNumberResponse {
    private EditMessage message;

    public EditPhoneNumberResponse(EditPhoneNumberResponseBody message) {
        this.message = message.getMessage();
    }

    public EditMessage getMessage(){
        return message;
    }
}
