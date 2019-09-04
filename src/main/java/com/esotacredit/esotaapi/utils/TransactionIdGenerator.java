package com.esotacredit.esotaapi.utils;

import java.util.UUID;

public class TransactionIdGenerator {

    public static String getTransactionID(){
        UUID uniqueKey = UUID.randomUUID();
        return String.valueOf(uniqueKey);
    }

}
