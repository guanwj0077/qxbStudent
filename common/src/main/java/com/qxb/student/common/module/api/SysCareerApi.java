package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.SysCareer;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

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
    @POST("sysCareer/getList")
    Observable<ApiModel<List<SysCareer>>> sysCareerList(@Query("depth") String depth);



}
