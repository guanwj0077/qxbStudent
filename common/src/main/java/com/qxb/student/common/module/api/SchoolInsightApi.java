package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 智能选校
 * @author
 */
public interface SchoolInsightApi {

    /**
     * 智能选校获取学校列表
     * @param ids
     * @param province
     * @param sprovince
     * @param profess
     * @param page
     * @param rows
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("school/listbyids_new")
    Observable<ApiModel<String>> schoolInsightGetList(@Query("ids") String ids, @Query("province") String province,@Query("sprovince") String sprovince, @Query("profess") String profess, @Query("page") String page, @Query("rows") String rows);



}
