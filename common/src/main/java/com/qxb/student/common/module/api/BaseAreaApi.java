package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.BaseArea;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 地区
 */
public interface BaseAreaApi {

    /**
     * 查询省份列表
     *
     * @param endCode 省份编码（查询小于该编码的省份）
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("base/getProvince")
    Call<ApiModel<List<BaseArea>>> getProvinceList(@Field("end_code") String endCode);

    /***
     * 根据省份获取所有城市列表
     * @param province   省份编码
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("baseArea/getCity")
    Call<ApiModel<List<BaseArea>>> getCityListByProvinceCode(@Field("province") String province);


}
