package com.esotacredit.esotaapi.api.registration.edit.editname;

import com.esotacredit.esotaapi.api.registration.edit.object.EditMessage;

public class EditNameResponseBody {
    private EditMessage message;

    public EditNameResponseBody(EditMessage message) {
        this.message = message;
    }

    public EditMessage getMessage() {
        return message;
    }

    public void setMessage(EditMessage message) {
        this.message = message;
    }
}
