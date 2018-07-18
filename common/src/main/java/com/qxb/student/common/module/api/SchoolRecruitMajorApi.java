package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.CollegeMajorRecruit;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

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
    @FormUrlEncoded
    @POST("school/recruitMajorList_new")
    Observable<ApiModel<String>> getSchoolRecruitMajor(@Field("school_id") String schoolId, @Field("province") String province);

    /**
     * 获取志愿信息
     * @param id 学校专业信息
     * @param stuId
     * @param province 招生省份
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded    @POST("school/getSchoolProfessNew")
    Observable<ApiModel<CollegeMajorRecruit>> getSchoolProfessNew(@Field("id") String id, @Field("stu_id") String stuId, @Field("province") String province);


}
