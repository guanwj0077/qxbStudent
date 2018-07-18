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

    /**
     * 标准专业库说明/在招专业库说明
     * @param tag_code 类别编码(必传) rule_major 标准 no_rule_major 在招
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("major/tag")
    Observable<ApiModel<String>> majorTag(@Query("tag_code") String tag_code);

    /**
     * 专业搜索
     * @param province 省份
     * @param categoryCode 专业类别编码
     * @param majorName 专业名称
     * @param subjectType 1：文 2：理
     * @param page
     * @param rows 默认20
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("major/search")
    Observable<ApiModel<String>> majorSearch(@Query("province") String province,@Query("category_code") String categoryCode,
                                          @Query("major_name") String majorName,@Query("subject_type") String subjectType,
                                          @Query("page") String page,@Query("rows") String rows);


}
