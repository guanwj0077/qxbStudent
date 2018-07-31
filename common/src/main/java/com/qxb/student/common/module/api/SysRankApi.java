package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 通用排名
 */
public interface SysRankApi {

    /**
     * 通用排名接口
     * @param page
     * @param rows 默认10
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("sysRank/list/1/yxfy")
    Call<ApiModel<String>> sysRankList(@Field("page") String page, @Field("rows") String rows);



}
