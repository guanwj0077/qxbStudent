package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.BaseSubjectCategory;
import com.qxb.student.common.module.bean.SubjectCategory;

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

    /**
     * 专业大类列表
     * @param type 1:获取学科门类列表 2：获取学校学科得分
     * @param name
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("subject/getList")
    Observable<ApiModel<List<SubjectCategory>>> getSubjectList(@Query("type") String type, @Query("name") String name);

    /**
     * 学科实力排行学校列表
     * @param id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("subject/getSchoolList")
    Observable<ApiModel<List<SubjectCategory>>> getSchoolListBySubjectId(@Query("id") String id);

}