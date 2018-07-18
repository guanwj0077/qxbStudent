package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.SchoolNews;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 学校招生简章
 */
public interface SchoolNewsApi {

    /**
     * 院校招生简章、资讯列表
     * @param schoolId
     * @param type 3 普通高校招生简章 7 自主招生简章 8 自主招生院校资讯
     * @param title 问题标题
     * @param page
     * @param rows  默认20
     * @return
     */
    @POST("school/newslist")
    Observable<ApiModel<List<SchoolNews>>> getSchoolNewslist(@Query("school_id") String schoolId, @Query("type") String type, @Query("title") String title, @Query("page") String page, @Query("rows") String rows);

    /**
     * 根据id查询院校招生简章、资讯详情,返回网页
     * @param newsId
     * @return
     */
    @POST("view/school/news/detail")
    Observable<String> schoolNewsDetail(@Query("id") String newsId);
}
