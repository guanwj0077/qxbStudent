package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 短信
 */
public interface SmsApi {

    /**
     * 验证短信验证码
     *
     * @param tel
     * @param smsCode
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("SMS/VaildCode")
    Observable<ApiModel<String>> vaildCode(@Field("tel") String tel, @Field("smsCode") String smsCode);


    /**
     * 新短信验证码
     *
     * @param tel  手机号
     * @param type 1:注册    2:找回密码
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("SMS/CreateCode_new/{tel}/{type}")
    Observable<ApiModel<String>> CreateCode(@Path("tel") String tel, @Path("type") String type);

}
