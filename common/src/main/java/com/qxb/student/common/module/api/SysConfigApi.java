package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.SysConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 系统配置
 */
public interface SysConfigApi {


    /**
     * 获取系统配置信息
     * @param type：类型（必传）
     * @param pCode：编码（必传）
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("sysconfig/getSysConfigList")
    Call<ApiModel<List<SysConfig>>> getSysConfigList(@Field("type") String type, @Field("p_code") String pCode);

    /**
     * 获取客户端高考分输入控制配置
     * @param id 学生id
     * @param province 学生所在省份
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded    @POST("sysconfig/getGaokaoInputConfig")
    Call<ApiModel<List<SysConfig>>> getGaokaoInputConfig(@Field("id") String id, @Field("province") String province);



}
