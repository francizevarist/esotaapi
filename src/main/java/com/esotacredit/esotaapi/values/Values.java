package com.esotacredit.esotaapi.values;

public class Values {

    public static int EMPTY_OFF_VALUE = 0;
    public static int EMPTY_ACTIVE_VALUE = 1;
    public static String EMPY_STRING = "";

    /**
     * Payment States
     */
    public static int PAYMENT_NULL = 0;
    public static int PAYMENT_PENDING = 1;
    public static int PAYMENT_COMPLETED = 2;


    /**
     * Credits values
     */
    public static int MILESTONE_STEPS = 2;
    public static int BASELINE = 2;
    public static int TOTALNODES = 3;
    public static int FIRST_BASE_SIZE = 3;


    /**
     * Network Note Type
     */
    public static String NODE_PURCHASED = "purchased";
    public static String NODE_DROPED = "droped";


    /**
     * Server Address
     */
    private static String localHost = "192.168.43.168:9000/";
    private static String liveHost = "fd7e7f07.ngrok.io/";
    public static String IMAGE_FILE_FORMAT = ".jpg"; //.jpg
    public static String SERVER_ADDRESS = "http://"+localHost;

}
