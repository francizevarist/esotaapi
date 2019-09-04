package com.esotacredit.esotaapi.api.registration.edit.editname;

import com.esotacredit.esotaapi.api.registration.edit.object.EditMessage;

public class EditNameResponse {
    private EditMessage message;

    public EditNameResponse(EditNameResponseBody message) {
        this.message = message.getMessage();
    }

    public EditMessage getMessage() {
        return message;
    }
}
