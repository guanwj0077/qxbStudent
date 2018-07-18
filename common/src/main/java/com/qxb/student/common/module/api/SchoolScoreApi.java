package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 学校分数线
 */
public interface SchoolScoreApi {

    /**
     * 学校分数线
     * @param schoolId
     * @param province
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("school/scorelist_new")
    Observable<ApiModel<String>> getSchoolScore(@Field("school_id") String schoolId, @Field("province") String province);


}
