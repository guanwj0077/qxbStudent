package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.CollegeFreedomMajorRecruit;
import com.qxb.student.common.module.bean.RecomSchool;
import com.qxb.student.common.module.bean.SchoolNews;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 学校招生简章
 */
public interface SchoolNewsApi {

    /**
     * 院校招生简章、资讯列表
     *
     * @param schoolId
     * @param type     3 普通高校招生简章 7 自主招生简章 8 自主招生院校资讯
     * @param title    问题标题
     * @param page
     * @return
     */
    @FormUrlEncoded
    @POST("school/newslist")
    Call<ApiModel<List<SchoolNews>>> getSchoolNewslist(@Field("school_id") String schoolId, @Field("type") String type, @Field("title") String title, @Field("page") String page);

    /**
     * 根据id查询院校招生简章、资讯详情,返回网页
     *
     * @param newsId
     * @return
     */
    @FormUrlEncoded
    @POST("view/school/news/detail")
    Call<String> schoolNewsDetail(@Field("id") String newsId);

    /**
     * 招生简介（根据学校id获取符合条件的第一条自招招生简章详情，返回网页）
     *
     * @param schoolId 学校id
     * @param type     为7
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("view/school/freedomNews/detail")
    Call<String> schoolFreedomNewsDetail(@Field("school_id") String schoolId, @Field("type") String type);

    /**
     * 自招院校详情
     *
     * @param schoolId
     * @param studentId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("freedomRecruit/school/getSchoolRecruitDetailById")
    Call<ApiModel<RecomSchool>> getSchoolRecruitDetailById(@Field("school_id") String schoolId, @Field("student_id") String studentId);

    /**
     * 自招专业详情
     *
     * @param majorId 专业id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("freedomRecruit/school/majorDetails")
    Call<ApiModel<CollegeFreedomMajorRecruit>> getSchoolRecruitDetailById(@Field("id") String majorId);

}
