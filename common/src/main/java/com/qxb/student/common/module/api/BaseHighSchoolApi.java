package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.BaseHighSchool;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

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
    @FormUrlEncoded
    @POST("base/highschoollistByCode")
    Observable<ApiModel<List<BaseHighSchool>>> highschoollistByCode(@Field("province") String province, @Field("city") String city, @Field("area") String area);


}
