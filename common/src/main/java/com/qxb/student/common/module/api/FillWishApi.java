package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.SysAd;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 志愿填报
 *
 * @author
 */
public interface FillWishApi {

    /**
     * 志愿表详情问专家跳转网页url取配置
     *
     * @return
     */
    @FormUrlEncoded
    @POST("wish/askSpecial")
    Observable<ApiModel<String>> wishAskSpecial();

    /**
     * 一键填报志愿检查是否付费
     * @param accountId 账户id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("wish/isBuy")
    Observable<ApiModel<String>> isBuyFillWish(@Field("account_id") String accountId);
}
