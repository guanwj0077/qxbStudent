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
 * 国家标准专业
 */
public interface BaseProfessionalsApi {

    /**
     * 获取专业详情
     * @param id
     * @param stuId
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("baseProfessionals/getProfesById")
    Observable<ApiModel<List<BaseSubjectCategory>>> getProfesById(@Query("id") String id, @Query("stu_id") String stuId);

    /**
     * 获取专业列表
     * @param type 1本科  2专科
     * @param name 专业名称
     * @param categoryCode 专业类别编码
     * @param rows 每页行数 默认10
     * @param page 当前页数 默认 1
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("baseProfessionals/listForApi")
    Observable<ApiModel<List<BaseSubjectCategory>>> getProfesList(@Query("type") String type,@Query("name") String name,@Query("category_code") String categoryCode,
                                                                  @Query("rows") String rows,@Query("page") String page);


}
