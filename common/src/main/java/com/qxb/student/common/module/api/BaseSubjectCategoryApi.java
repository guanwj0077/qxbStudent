package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.BaseSubjectCategory;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 基础学科大类-专业库
 */
public interface BaseSubjectCategoryApi {

    /**
     * 通过深度查询学科大类列表
     * @param depth 深度
     * @param type  1：本科 2：专科
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("baseSubjectCategory/getListByDepth")
    Observable<ApiModel<List<BaseSubjectCategory>>> getBaseSubjectCategoryListByDepth(@Query("depth") String depth, @Query("type") String type);

    /***
     * 通过父编码查询学科列表
     * @param pCode
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("baseSubjectCategory/getListByParent")
    Observable<ApiModel<List<BaseSubjectCategory>>> getBaseSubjectCategoryListByParent(@Query("p_code") String pCode);


}
