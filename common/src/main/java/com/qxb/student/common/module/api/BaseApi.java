package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.AppVersion;

import io.reactivex.Observable;
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
    @FormUrlEncoded
    @POST("base/getYear")
    Observable<ApiModel<String>> getCurrentYear();

    /**
     * 版本更新
     * @param clientType 客户端类型
     * @param versionCode 版本值
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("update/version")
    Observable<ApiModel<AppVersion>> updateVersion(@Field("client_type")String clientType, @Field("version_code")String versionCode);
}
