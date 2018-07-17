package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.BaseNews;
import com.qxb.student.common.module.bean.BaseNotic;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

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
    @POST("base/noticlist")
    Observable<ApiModel<List<BaseNotic>>> noticList(@Query("page") String page, @Query("rows") String rows);

    /**
     * 最新的一条未读的系统通知记录
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("base/newnotic")
    Observable<ApiModel<List<BaseNotic>>> newnotic();

    /**
     * 根据id查询系统通知的详情
     * @param noticId
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("base/noticDetail")
    Observable<ApiModel<BaseNotic>> noticDetail(@Query("id") String noticId);

    /**
     * 根据id查询系统通知的详情,返回网页
     * @param noticId
     * @return
     */
    @POST("view/notic/detail")
    Observable<String> viewNoticDetail(@Query("id") String noticId);
}
