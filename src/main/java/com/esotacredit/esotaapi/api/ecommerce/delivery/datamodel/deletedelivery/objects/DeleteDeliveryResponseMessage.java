package com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.deletedelivery.objects;

public class DeleteDeliveryResponseMessage {
    private String messsage;

    public DeleteDeliveryResponseMessage() {}

    public DeleteDeliveryResponseMessage(String messsage) {
        this.messsage = messsage;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

}
