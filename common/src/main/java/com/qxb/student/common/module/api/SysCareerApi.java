package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.SysCareer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 职业性格测评
 * @author
 */
public interface SysCareerApi {

    /**
     * 获取职业列表
     * @param depth 深度 默认为1
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("sysCareer/getList")
    Call<ApiModel<List<SysCareer>>> sysCareerList(@Field("depth") String depth);



}
