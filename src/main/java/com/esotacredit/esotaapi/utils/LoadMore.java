package com.esotacredit.esotaapi.utils;

public class LoadMore {

    public static String getPage(int pageNumber){
        int limit = 10;
        int offset = limit * pageNumber;
        return " LIMIT "+limit+" OFFSET "+offset;
    }

}
