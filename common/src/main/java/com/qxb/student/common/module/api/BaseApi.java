package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.AppVersion;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 基础接口
 */
public interface BaseApi {

    /**
     * 获取当前年份
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("base/getYear")
    Call<ApiModel<String>> getCurrentYear();

    /**
     * 版本更新
     * @param clientType 客户端类型
     * @param versionCode 版本值
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("update/version")
    Call<ApiModel<AppVersion>> updateVersion(@Field("client_type")String clientType, @Field("version_code")String versionCode);

    /**
     * 用户使用帮助视频地址
     * @return
     */
    @FormUrlEncoded
    @POST("user/useHelpVideo")
    Call<ApiModel<String>> useHelpVideo();
}
