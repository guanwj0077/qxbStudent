package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.SysAd;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 短信
 */
public interface SmsApi {

    /**
     * 验证短信验证码
     * @param tel
     * @param smsCode
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("SMS/VaildCode")
    Observable<ApiModel<String>> vaildCode(@Query("tel") String tel, @Query("smsCode") String smsCode);


}
