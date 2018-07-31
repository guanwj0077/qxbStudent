package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

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
    @FormUrlEncoded
    @POST("pay")
    Call<ApiModel<String>> pay(@Field("user_id") String userId, @Field("channel") String channel, @Field("clientIp") String clientIp,
                               @Field("amount") String amount, @Field("currency") String currency, @Field("subject") String subject, @Field("body") String body);

    /**
     * 学生支付状态查询接口
     * @param stuId 学生id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("pay/search")
    Call<ApiModel<String>> paySearch(@Field("stu_id") String stuId);

}
