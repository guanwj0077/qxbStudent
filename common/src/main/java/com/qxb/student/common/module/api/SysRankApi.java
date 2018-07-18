package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

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
    @POST("sysRank/list/1/yxfy")
    Observable<ApiModel<String>> sysRankList(@Query("page") String page, @Query("rows") String rows);



}
