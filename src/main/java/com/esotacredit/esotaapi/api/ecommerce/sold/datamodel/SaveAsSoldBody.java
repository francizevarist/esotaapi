package com.esotacredit.esotaapi.api.ecommerce.sold.datamodel;

import com.esotacredit.esotaapi.api.ecommerce.sold.objects.DeliveryInformation;
import com.esotacredit.esotaapi.api.ecommerce.sold.objects.Sold;

import java.io.Serializable;
import java.util.List;

public class SaveAsSoldBody  implements Serializable {
    DeliveryInformation deliveryInformation;
    List<Sold> sold;

    public SaveAsSoldBody() {}

    public SaveAsSoldBody(DeliveryInformation deliveryInformation, List<Sold> sold) {
        this.deliveryInformation = deliveryInformation;
        this.sold = sold;
    }

    public DeliveryInformation getDeliveryInformation() {
        return deliveryInformation;
    }

    public List<Sold> getSold() {
        return sold;
    }

}
