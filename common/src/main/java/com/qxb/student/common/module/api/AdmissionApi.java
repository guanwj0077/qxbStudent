package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.SysStaff;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 招生办
 *
 * @author
 */
public interface AdmissionApi {


    /**
     * 获取市招生办banner图片
     *
     * @param areaCode 地区编码
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("admissions/banner")
    Call<ApiModel<String>> getBannerList(@Field("area_code") String areaCode);

    /**
     * 获取该市招办及区招办的员工
     *
     * @param areaCode 地区编码
     * @param page
     * @param rows     默认10
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("admissions/staffList")
    Call<ApiModel<List<SysStaff>>> getStaffList(@Field("area_code") String areaCode, @Field("page") String page, @Field("rows") String rows);


}
