package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.RongyUser;
import com.qxb.student.common.module.bean.UserSchoolTeacher;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 融云聊天相关
 */
public interface RongyUserApi {

    /**
     * 学校主页咨询老师列表
     *
     * @param schoolId
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("teacher/listBySchoolId")
    Call<ApiModel<List<RongyUser>>> teacherListBySchoolId(@Field("school_id") String schoolId);

    /**
     * 在线咨询-查询聊天老师列表
     *
     * @param schoolName 学校名称
     * @param page
     * @param rows       默认20
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("teacher/chatlist")
    Call<ApiModel<List<UserSchoolTeacher>>> getTeacherChatList(@Field("school") String schoolName, @Field("page") String page, @Field("rows") String rows);

    /**
     * 通过accountId查询聊天老师列表
     *
     * @param accountId 账户id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("teacher/getListByPhone")
    Call<ApiModel<List<UserSchoolTeacher>>> getTeacherChatListByAcoountId(@Field("account_id") String accountId);

    /**
     * 监听用户发送消息（学生给老师发消息，老师不在线则发送短信）
     *
     * @param sendUserId
     * @param targetId
     * @return
     */
    @FormUrlEncoded
    @POST("chat/sendMsg")
    Call<ApiModel<String>> chatSendMsg(@Field("sendUserId") String sendUserId, @Field("targetId") String targetId);

    /**
     * 官方客服机构编码及电话号码配置
     *
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("chat/getCustService")
    Call<ApiModel<String>> getCustService();


}
