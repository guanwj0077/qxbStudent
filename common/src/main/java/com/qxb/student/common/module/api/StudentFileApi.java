package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

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
    @POST("studentFile/info")
    Observable<ApiModel<String>> getStudentFileInfo(@Query("stu_id") String stuId);



}
