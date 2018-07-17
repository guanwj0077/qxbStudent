package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.BaseHighSchool;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 高中学校
 */
public interface BaseHighSchoolApi {

    /**
     * 根据省市区获得高中学校列表
     * @param province 省份编码
     * @param city 城市编码
     * @param area 地区编码
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("base/highschoollistByCode")
    Observable<ApiModel<List<BaseHighSchool>>> highschoollistByCode(@Query("province") String province,@Query("city") String city,@Query("area") String area);


}
