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
 * 支付
 */
public interface PayApi {

    /**
     * 支付
     * @param userId
     * @param channel
     * @param clientIp
     * @param amount
     * @param currency
     * @param subject
     * @param body
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("pay")
    Observable<ApiModel<String>> pay(@Query("user_id") String userId, @Query("channel") String channel, @Query("clientIp") String clientIp,
                                          @Query("amount") String amount,@Query("currency") String currency,@Query("subject") String subject,@Query("body") String body);



}
