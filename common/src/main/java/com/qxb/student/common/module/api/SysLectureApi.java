package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.Constant;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.Lecture;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 听讲座
 * @author
 */
public interface SysLectureApi {

    /**
     * 新版听讲座视频列表
     * @param accountId 账户id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("article/lecture/list2")
    Call<ApiModel<Lecture>> lectureList(@Field("account_id") String accountId);


    /**
     *
     * 使用帮助视屏地址
     *
     * */
    @Headers(Config.AUTH_COMMON)
    @POST("user/useHelpVideo")
    Call<ApiModel<String>>useHelpVideo();



}
