package com.emmbi.mobile.example.util;

/**
 * Created by mbagliojr on 3/27/15.
 */
public class SessionAttributes {

    public static Long currentUserId;

    public static String ACCESS_TOKEN;
    public static long TOKEN_CREATED_DATETIME;
    public static long TOKEN_EXPIRATION_DATETIME;
    public static String TOKEN_SCOPE;
    public static String TOKEN_TYPE;
    public static boolean PORTAL_2;

    public static void clear() {
        currentUserId = null;

        ACCESS_TOKEN = null;
        TOKEN_CREATED_DATETIME = 0;
        TOKEN_EXPIRATION_DATETIME = 0;
        TOKEN_SCOPE = null;
        TOKEN_TYPE = null;
        PORTAL_2 = false;
    }
}
