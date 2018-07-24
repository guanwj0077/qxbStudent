package com.qxb.student.common.module;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * @author winky
 * @date 2018/7/24
 */
public interface TestApi {

    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("school/getSchoolById")
    Observable<ApiModel<String>> getSchoolById(@Field("school_id") String school_id, @Field("student_id") String student_id);
}
