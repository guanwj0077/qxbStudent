package com.qxb.student.common;

public final class Config {
    /**
     * 是否调试模式
     */
    public static final boolean isDebug = false;

    private static final String SERVER_URL_RELEASE = "https://api.qiuxuebao.com/api/";
    private static final String SERVER_URL_DEBUG = "http://qxb.ylcplus.club:8081/qxb_api/api/";

    public static final String SERVER_URL = isDebug ? SERVER_URL_DEBUG : SERVER_URL_RELEASE;


    /**
     * 设计屏幕宽、高
     */
    public static final int[] DESIGN_SCREEN = {1080, 1920};

    /**
     * SharedPreferences 缓存通用数据，退出不清除
     */
    public static final String SHARE_CURRENCY = "currency";

    /**
     * SharedPreferences 缓存用户数据，退出登录需清除
     */
    public static final String SHARE_CUSTOM = "custom";
    /**
     * 即时生效换字体，是否采集textview
     */
    public static final boolean COLLECTION_TEXTVIEW = true;

    public static final String NAVIGATION_ID = "navigation_id";

    public static final String AUTH = "auth";
    public static final String COMMON = "common";
    public static final String CUSTOM = "custom";
    public static final String AUTH_COMMON = "auth:common";
    public static final String AUTH_CUSTOM = "auth:custom";


}
