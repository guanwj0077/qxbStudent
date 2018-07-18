package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.BaseArea;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

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
    @POST("base/getProvince")
    Observable<ApiModel<List<BaseArea>>> getProvinceList(@Query("end_code") String endCode);

    /***
     * 根据省份获取所有城市列表
     * @param province   省份编码
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("baseArea/getCity")
    Observable<ApiModel<List<BaseArea>>> getCityListByProvinceCode(@Query("province") String province);


}