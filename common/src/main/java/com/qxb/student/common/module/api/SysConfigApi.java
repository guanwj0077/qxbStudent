package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.BaseArea;
import com.qxb.student.common.module.bean.SysConfig;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

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
    @POST("sysconfig/getSysConfigList")
    Observable<ApiModel<List<SysConfig>>> getSysConfigList(@Query("type") String type, @Query("p_code") String pCode);

    /**
     * 获取客户端高考分输入控制配置
     * @param id 学生id
     * @param province 学生所在省份
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("sysconfig/getGaokaoInputConfig")
    Observable<ApiModel<List<SysConfig>>> getGaokaoInputConfig(@Query("id") String id, @Query("province") String province);



}