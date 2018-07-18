package com.qxb.student.common.module.api;

import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.SchoolMsg;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 学校通知
 */
public interface SchoolMsgApi {

    /**
     * 学校通知列表（后台用户认证头被注释）
     * @param studentId
     * @param n 标志  传大于0的数字
     * @param page
     * @param rows 默认20
     * @return
     */
    @POST("school/noticlist")
    Observable<ApiModel<List<SchoolMsg>>> getSchoolNoticlist(@Query("student_id") String studentId, @Query("n") String n, @Query("page") String page, @Query("rows") String rows);

    /**
     * 最新学校通知
     * @param studentId
     * @return
     */
    @POST("school/newnotic")
    Observable<ApiModel<List<SchoolMsg>>> schoolNewNotic(@Query("student_id") String studentId);

    /**
     * 学校通知已读
     * @param schoolNoticId
     * @return
     */
    @POST("school/noticread")
    Observable<ApiModel<String>> schoolNoticRead(@Query("id") String schoolNoticId);

    /**
     * 学校通知详情-返回网页
     * @param schoolMsgId
     * @return
     */
    @POST("view/schoolmsg/detail")
    Observable<String> viewSchoolMsgDetail(@Query("id") String schoolMsgId);
}
