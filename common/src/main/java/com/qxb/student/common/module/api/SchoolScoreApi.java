package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.SchoolNews;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

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
    @POST("school/scorelist_new")
    Observable<ApiModel<String>> getSchoolScore(@Query("school_id") String schoolId, @Query("province") String province);


}
