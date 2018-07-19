package com.qxb.student.common;

public final class Config {
    /**
     * 是否调试模式
     */
    public static final boolean isDebug = false;

    private static final String SERVER_URL_RELEASE = "https://api.qiuxuebao.com/api/";
    private static final String SERVER_URL_DEBUG = "http://qxb.ylcplus.club:8081/qxb_api/api/";

    /**
     * 服务器地址
     */
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
     * SharedPreferences 缓存配置数据
     */
    public static final String SHARE_DATA = "data";
    /**
     * SharedPreferences 缓存用户数据，退出登录需清除
     */
    public static final String SHARE_CUSTOM = "custom";
    /**
     * 即时生效换字体，是否采集textview
     */
    public static final boolean COLLECTION_TEXTVIEW = true;

    public static final String NAVIGATION_ID = "navigation_id";

    /**
     * 定义接口请求头KEY
     */
    public static final String AUTH = "auth";
    /**
     * 普通认证头标记，用于替换
     */
    public static final String COMMON = "common";
    /**
     * 用户认证头标记，用于替换
     */
    public static final String CUSTOM = "custom";
    /**
     * 普通认证头，用于接口标记
     */
    public static final String AUTH_COMMON = "auth:common";
    /**
     * 用户认证头，用于接口标记
     */
    public static final String AUTH_CUSTOM = "auth:custom";
    /**
     * 普通认证头的值
     */
    public static final String AUTH_COMMON_SECRET = "YjQzZjNjZTMzNDdmZDUwMmRmYjUxNWRhOTgyNjY2Mjg6Yjc1MjI5N2RkMjk4 MDU3NzVjYmJlZGNlYjMwNGNiOTc=";

    /**
     * http一页加载条数
     */
    public static final int PAGE_SIZE = 20;

    /**
     * 起动一个活动时带的状态码
     */
    public static final int ACT_STARTED = 1001;
    /**
     * 关闭活动带回一个取消的状态码
     */
    public static final int ACT_CANCELED = 1002;
    /**
     * 关闭活动带回一个确认的状态码
     */
    public static final int ACT_CONFIRM = 1003;
}
