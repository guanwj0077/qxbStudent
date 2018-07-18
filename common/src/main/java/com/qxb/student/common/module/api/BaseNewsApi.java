package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.BaseNews;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

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
    @FormUrlEncoded
    @POST("base/newsDetail")
    Observable<ApiModel<BaseNews>> newsDetail(@Field("id")String newsId);

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
    @FormUrlEncoded
    @POST("base/newslist")
    Observable<ApiModel<List<BaseNews>>> newslist(@Field("type") String type, @Field("province")String province, @Field("title")String title, @Field("student_id") String studentId, @Field("page")String page, @Field("rows")String rows);

    /**
     * 根据id查询系统新闻的详情,返回网页
     * @param newsId
     * @return
     */
    @FormUrlEncoded
    @POST("view/news/detail")
    Observable<String> viewNewsDetail(@Field("id") String newsId);
}
