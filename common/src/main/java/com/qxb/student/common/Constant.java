package com.qxb.student.common;

/**
 * created on: 2018/7/19 15:28
 * description:
 *
 * @author Administrator
 */
public class Constant {

    /**
     * SharedPreferences 缓存通用数据，退出不清除
     */
    public static final String SHARE_FILE_CURRENCY = "currency";
    /**
     * SharedPreferences 缓存配置数据
     */
    public static final String SHARE_FILE_DATA = "data";
    /**
     * SharedPreferences 缓存用户数据，退出登录需清除
     */
    public static final String SHARE_FILE_CUSTOM = "custom";
    /**
     * share  为数据存取用
     * intent 为传值用
     */
    public static final String DEFAULT_PROVINCE = "湖北省";
    public static final String WEN_KE = "文科";
    public static final String LIKE = "理科";
    public static final String YISHU_WENKE = "艺术文科";
    public static final String YISHU_LIKE = "艺术理科";
    public static final String MAN = "男";
    public static final String WOMEN = "女";

    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;


    public static final String PURPOSE = "purpose";
    public static final String PURPOSE_ONE = "purpose_one";
    public static final String USER_REGISTER = "user_register";
    public static final String USER_PASSWORD = "user_password";


    public static final String SHARE_PHONE = "share_phone";
    /**
     * 跳转学校id
     */
    public static final String NAV_SCHOOL_ID = "nav_school_id";
    public static final String NAV_SCHOOL_BAT = "nav_school_bat";


    /**
     * 根据id查询院校招生简章、资讯详情,返回网页
     */
    public static final String SCHOOL_NEW_DETAIL = Config.SERVER_URL + "view/school/news/detail?id=";

    /**
     * 伴考详情
     * https://www.qiuxuebao.com/web//b_news/detail?id=
     */
    public static final String BANKAO_NEW_DETAIL = Config.SERVER_HOST + "web//b_news/detail?id=";


    //----------------------------------------------------------------------------------------------
    /**
     * 使用帮助视频url
     */
    public static final String CONFIG_USE_HELPER_URL = "config_use_helper_url";
    /**
     * 融云token
     */
    public static final String CONFIG_ROOM_TOKEN = "config_room_token";
}
