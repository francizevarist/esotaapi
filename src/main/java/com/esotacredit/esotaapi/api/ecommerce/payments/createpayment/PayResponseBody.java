package com.esotacredit.esotaapi.api.ecommerce.payments.createpayment;

public class PayResponseBody {
    private String link;

    public PayResponseBody() {}

    public PayResponseBody(String confirmationLink) {
        this.link = confirmationLink;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
