package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.RongyUser;

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



}
