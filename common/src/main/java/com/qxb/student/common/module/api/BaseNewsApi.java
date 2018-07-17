package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.BaseNews;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 伴考、一分一段等资讯
 */
public interface BaseNewsApi {

    /**
     * 新闻详情,返回新闻实体
     * @param newsId
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("base/newsDetail")
    Observable<ApiModel<BaseNews>> newsDetail(@Query("id")String newsId);

    /**
     * 系统新闻列表
     * @param type 5：一分一段
     * @param province
     * @param title
     * @param studentId
     * @param page
     * @param rows 默认20
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("base/newslist")
    Observable<ApiModel<List<BaseNews>>> newslist(@Query("type") String type, @Query("province")String province, @Query("title")String title, @Query("student_id") String studentId, @Query("page")String page, @Query("rows")String rows);

    /**
     * 根据id查询系统新闻的详情,返回网页
     * @param newsId
     * @return
     */
    @POST("view/news/detail")
    Observable<String> viewNewsDetail(@Query("id") String newsId);
}
