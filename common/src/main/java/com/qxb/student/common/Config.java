package com.qxb.student.common;

import okhttp3.MediaType;

public final class Config {
    /**
     * 是否调试模式
     */
    public static final boolean IS_DEBUG = false;

    private static final String SERVER_HOST_RELEASE = "https://api.qiuxuebao.com/";
    private static final String SERVER_HOST_DEBUG = "http://172.16.100.154:8080/qxb_api/";
//    private static final String SERVER_HOST_DEBUG = "http://qxb.ylcplus.club:8081/qxb_api/";

    public static final String SERVER_HOST = IS_DEBUG ? SERVER_HOST_DEBUG : SERVER_HOST_RELEASE;

    /**
     * 服务器地址
     */
    public static final String SERVER_URL = SERVER_HOST + "api/";

    /**
     * 即时生效换字体，是否采集textview
     */
    public static final boolean COLLECTION_TEXTVIEW = true;

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
    /**
     * 后台返回成功响应CODE
     */
    public static final int HTTP_SUCCESS = 1;
    /**
     * http请求数据类型
     */
    public static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8;");
    /**
     * 同步锁
     */
    public static final Object LOCK = new Object();
}
