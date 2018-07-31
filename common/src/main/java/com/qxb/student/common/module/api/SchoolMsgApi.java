package com.qxb.student.common.module.api;

import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.SchoolMsg;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 学校通知
 */
public interface SchoolMsgApi {

    /**
     * 学校通知列表（后台用户认证头被注释）
     *
     * @param studentId
     * @param n         标志  传大于0的数字
     * @param page
     * @param rows      默认20
     * @return
     */
    @FormUrlEncoded
    @POST("school/noticlist")
    Call<ApiModel<List<SchoolMsg>>> getSchoolNoticlist(@Field("student_id") String studentId, @Field("n") String n, @Field("page") String page, @Field("rows") String rows);

    /**
     * 最新学校通知
     *
     * @param studentId
     * @return
     */
    @FormUrlEncoded
    @POST("school/newnotic")
    Call<ApiModel<List<SchoolMsg>>> schoolNewNotic(@Field("student_id") String studentId);

    /**
     * 学校通知已读
     *
     * @param schoolNoticId
     * @return
     */
    @FormUrlEncoded
    @POST("school/noticread")
    Call<ApiModel<String>> schoolNoticRead(@Field("id") String schoolNoticId);

    /**
     * 学校通知详情-返回网页
     *
     * @param schoolMsgId
     * @return
     */
    @FormUrlEncoded
    @POST("view/schoolmsg/detail")
    Call<String> viewSchoolMsgDetail(@Field("id") String schoolMsgId);
}
