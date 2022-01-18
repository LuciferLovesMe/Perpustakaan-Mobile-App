package com.abim.perpustakaanapp;

public class MyReq {
    private static final String baseURL = "192.168.1.37:5000/";
    private static final String loginURL = "api/login";
    private static final String bukuURL = "api/buku";
    private static final String historyURL = "api/history";

    public static String getBaseURL() {
        return baseURL;
    }

    public static String getLoginURL() {
        return getBaseURL() + loginURL;
    }

    public static String getBukuURL() {
        return getBaseURL() + bukuURL;
    }

    public static String getHistoryURL() {
        return getBaseURL() + historyURL;
    }
}
