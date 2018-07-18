package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.CollegeMajorRecruit;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 学校在招专业
 * @author
 */
public interface SchoolRecruitMajorApi {

    /**
     * 学校在招专业
     * @param schoolId
     * @param province
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("school/recruitMajorList_new")
    Observable<ApiModel<String>> getSchoolRecruitMajor(@Query("school_id") String schoolId, @Query("province") String province);

    /**
     * 获取志愿信息
     * @param id 学校专业信息
     * @param stuId
     * @param province 招生省份
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("school/getSchoolProfessNew")
    Observable<ApiModel<CollegeMajorRecruit>> getSchoolProfessNew(@Query("id") String id, @Query("stu_id") String stuId, @Query("province") String province);


}
