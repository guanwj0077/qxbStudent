package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.BaseSubjectCategory;
import com.qxb.student.common.module.bean.SubjectCategory;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

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
    @FormUrlEncoded
    @POST("baseSubjectCategory/getListByDepth")
    Call<ApiModel<List<BaseSubjectCategory>>> getBaseSubjectCategoryListByDepth(@Field("depth") String depth, @Field("type") String type);

    /***
     * 通过父编码查询学科列表
     * @param pCode
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("baseSubjectCategory/getListByParent")
    Call<ApiModel<List<BaseSubjectCategory>>> getBaseSubjectCategoryListByParent(@Field("p_code") String pCode);

    /**
     * 专业大类列表
     * @param type 1:获取学科门类列表 2：获取学校学科得分
     * @param name
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("subject/getList")
    Call<ApiModel<List<SubjectCategory>>> getSubjectList(@Field("type") String type, @Field("name") String name);

    /**
     * 学科实力排行学校列表
     * @param id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("subject/getSchoolList")
    Call<ApiModel<List<SubjectCategory>>> getSchoolListBySubjectId(@Field("id") String id);

}
