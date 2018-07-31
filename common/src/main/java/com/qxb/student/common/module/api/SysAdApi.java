package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.FunctionItem;
import com.qxb.student.common.module.bean.SysAd;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 系统广告
 */
public interface SysAdApi {

    /***
     * 首页轮播图广告,求学头条等广告列表
     * @param type
     * [
     *  home_ad：首页轮播图广告
     *  studying_headlines：求学头条
     *  with_test_ad：伴考广告
     *  product_ad1：艺考培训
     *  product_ad2：出国留学
     *  product_ad3：法国直通车
     *  product_ad4：职业技能
     * ]
     * @param province
     * @param studentId
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("sysAd/list")
    Call<ApiModel<List<SysAd>>> getSysAdList(@Field("type") String type, @Field("province") String province, @Field("student_id") String studentId);

    /**
     * 首页banner
     *
     * @param province 省份编码
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("sysAd/new_banner")
    Call<ApiModel<List<SysAd>>> getHomeBanner(@Field("province") String province);

    /**
     * 弹屏广告
     *
     * @param type      必传，只能是"pop_up_home_ad"(弹屏首页广告)或者"pop_up_school_ad"(弹屏院校库广告)
     * @param studentId 学生id（必传)
     * @param province  省份（必传)
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("sysAd/oppup")
    Call<ApiModel<List<SysAd>>> sysAdOppup(@Field("type") String type, @Field("student_id") String studentId, @Field("province") String province);

    /**
     * 开屏广告
     *
     * @param province 省份编码
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("sysAd/open_up_ad")
    Call<ApiModel<List<SysAd>>> sysAdOpenUpAd(@Field("province") String province);

    /**
     * 弹屏广告
     *
     * @param type     必传，pop_up_home_ad"(弹屏首页广告) pop_up_school_ad(弹屏院校库广告)
     * @param province 不传则查全国的广告
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("sysAd/new_pop_ad")
    Call<ApiModel<List<SysAd>>> getPopSysAd(@Field("type") String type, @Field("province") String province);

    /**
     * 直播首页广告 2.3 新版本 新图片
     *
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("chatRoom/liveHomeAd23")
    Call<ApiModel<String>> getLiveHomeAd();

    /**
     * 首页功能
     *
     * @param androidVersion 安卓app版本
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("sysconfig/getIndexFunction")
    Call<ApiModel<List<FunctionItem>>> getIndexFunctions(@Field("androidVersion") String androidVersion);
}
