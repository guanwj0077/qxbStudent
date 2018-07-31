package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.BaseProfessionals;
import com.qxb.student.common.module.bean.BaseSubjectCategory;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 国家标准专业
 */
public interface BaseProfessionalsApi {

    /**
     * 获取专业详情
     *
     * @param id
     * @param stuId
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("baseProfessionals/getProfesById")
    Call<ApiModel<List<BaseSubjectCategory>>> getProfesById(@Field("id") String id, @Field("stu_id") String stuId);

    /**
     * 获取专业列表
     *
     * @param type         1本科  2专科
     * @param name         专业名称
     * @param categoryCode 专业类别编码
     * @param rows         每页行数 默认10
     * @param page         当前页数 默认 1
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("baseProfessionals/listForApi")
    Call<ApiModel<List<BaseSubjectCategory>>> getProfesList(@Field("type") String type, @Field("name") String name, @Field("category_code") String categoryCode,
                                                                  @Field("rows") String rows, @Field("page") String page);

    /**
     * 标准专业库说明/在招专业库说明
     *
     * @param tag_code 类别编码(必传) rule_major 标准 no_rule_major 在招
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("major/tag")
    Call<ApiModel<String>> majorTag(@Field("tag_code") String tag_code);

    /**
     * 专业搜索
     *
     * @param province     省份
     * @param categoryCode 专业类别编码
     * @param majorName    专业名称
     * @param subjectType  1：文 2：理
     * @param page
     * @param rows         默认20
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("major/search")
    Call<ApiModel<String>> majorSearch(@Field("province") String province, @Field("category_code") String categoryCode,
                                             @Field("major_name") String majorName, @Field("subject_type") String subjectType,
                                             @Field("page") String page, @Field("rows") String rows);

    /**
     * 专业库根据名称搜索专业
     *
     * @param stuId        学生id
     * @param majorType    专业类别（必传）
     * @param majorName    专业名称（必传）
     * @param categoryCode 专业类别编码（必传）
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("baseProfessionals/getProfesByName")
    Call<ApiModel<List<BaseProfessionals>>> getProfesByName(@Field("stu_id") String stuId, @Field("major_type") String majorType,
                                                                  @Field("major_name") String majorName, @Field("category_code") String categoryCode);

}
