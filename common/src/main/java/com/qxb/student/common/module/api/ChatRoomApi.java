package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.RcChatRoom;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 聊天室
 *
 * @author
 */
public interface ChatRoomApi {

    /**
     * 直播详情
     *
     * @param id       直播室id（必传）
     * @param type     类型 1.老师 2.学生（必传）
     * @param relateId type =1 则为老师Id type=2则为学生id（必传）
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("chatRoom/liveDetail")
    Call<ApiModel<RcChatRoom>> getLiveDetail(@Field("id") int id, @Field("type") int type, @Field("relateId") int relateId);

    /**
     * 任意聊-学生评价老师
     *
     * @param accountId 老师 account_id（必传）
     * @param studentId 学生id（必传）
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("studentInfo/evaluateTeacher")
    Call<ApiModel<String>> evaluateTeacher(@Field("accountId") String accountId, @Field("studentId") String studentId);

    /**
     * 任意聊-直播订阅
     *
     * @param liveId       直播室ID（必传）
     * @param type         类型 1.老师 2.学生（必传）
     * @param subscriberId type =1 则为老师Id type=2则为学生id（必传）
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("chatRoom/liveSubscribe")
    Call<ApiModel<String>> liveSubscribe(@Field("liveId") int liveId, @Field("type") int type, @Field("subscriberId") int subscriberId);

    /**
     * 任意聊-直播间列表
     *
     * @param conditionMap rows：每页行数 默认10
     *                     page：当前页数 默认 1
     *                     status：直播间状态 1.审核中 2.未开始 3.进行中 4.已完成5.未通过 6.回看
     *                     isAll：是否查看全部直播列表 1.则查询所有直播列表 0或其他值 查询 2.3.4.6状态列表
     *                     teacherId：老师id
     *                     stuId：学生ID
     *                     assistantId：助教id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("chatRoom/chatRoomList")
    Call<ApiModel<List<RcChatRoom>>> chatRoomList(@FieldMap Map<String, Object> conditionMap);

    /**
     * 任意聊-学生聊天禁言
     *
     * @param liveId 聊天室id（必传）
     * @param type   默认0  0.查询禁言信息1 禁言 2取消禁言
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("chatRoom/bannedSpeak")
    Call<ApiModel<String>> bannedSpeak(@Field("id") int liveId, @Field("type") int type);

    /**
     * 任意聊-交换电话
     *
     * @param accountId
     * @param collegeAccountId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("chatRoom/exchangePhone")
    Call<ApiModel<String>> exchangePhone(@Field("accountId") String accountId, @Field("collegeAccountId") String collegeAccountId);
}
