package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.BaseNotic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 系统通知
 */
public interface BaseNoticApi {

    /**
     * 系统通知列表
     * @param page
     * @param rows 默认20
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("base/noticlist")
    Call<ApiModel<List<BaseNotic>>> noticList(@Field("page") String page, @Field("rows") String rows);

    /**
     * 最新的一条未读的系统通知记录
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("base/newnotic")
    Call<ApiModel<List<BaseNotic>>> newnotic();

    /**
     * 根据id查询系统通知的详情
     * @param noticId
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("base/noticDetail")
    Call<ApiModel<BaseNotic>> noticDetail(@Field("id") String noticId);

    /**
     * 根据id查询系统通知的详情,返回网页
     * @param noticId
     * @return
     */
    @FormUrlEncoded
    @POST("view/notic/detail")
    Call<String> viewNoticDetail(@Field("id") String noticId);
}
