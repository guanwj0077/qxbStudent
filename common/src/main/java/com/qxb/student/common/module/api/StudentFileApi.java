package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 学生档案
 */
public interface StudentFileApi {


    /**
     * 学生档案信息
     * @param stuId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("studentFile/info")
    Observable<ApiModel<String>> getStudentFileInfo(@Field("stu_id") String stuId);



}
