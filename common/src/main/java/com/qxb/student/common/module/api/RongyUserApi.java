package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.RongyUser;
import com.qxb.student.common.module.bean.UserSchoolTeacher;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 融云聊天相关
 */
public interface RongyUserApi {

    /**
     * 学校主页咨询老师列表
     * @param schoolId
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("teacher/listBySchoolId")
    Observable<ApiModel<List<RongyUser>>> teacherListBySchoolId(@Query("school_id") String schoolId);

    /**
     * 在线咨询-查询聊天老师列表
     * @param schoolName 学校名称
     * @param page
     * @param rows 默认20
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("teacher/chatlist")
    Observable<ApiModel<List<UserSchoolTeacher>>> getTeacherChatList(@Query("school") String schoolName, @Query("page") String page, @Query("rows") String rows);

    /**
     * 通过accountId查询聊天老师列表
     * @param accountId 账户id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("teacher/getListByPhone")
    Observable<ApiModel<List<UserSchoolTeacher>>> getTeacherChatListByAcoountId(@Query("account_id") String accountId);

    /**
     * 监听用户发送消息（学生给老师发消息，老师不在线则发送短信）
     * @param sendUserId
     * @param targetId
     * @return
     */
    @POST("chat/sendMsg")
    Observable<ApiModel<String>> chatSendMsg(@Query("sendUserId") String sendUserId,@Query("targetId") String targetId);

    /**
     * 官方客服机构编码及电话号码配置
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("chat/getCustService")
    Observable<ApiModel<String>> getCustService();



}
