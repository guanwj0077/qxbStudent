package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.School;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SchoolApi {

    @Headers(Config.COMMON)
    @POST("school/listIndex")
    Observable<ApiModel<List<School>>> getRecommendedColleges(@Query("stu_id") String studId, @Query("province") String provinceCode);

}
