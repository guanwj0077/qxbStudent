package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 学生档案
 */
public interface StudentFileApi {


    /**
     * 学生档案信息
     *
     * @param stuId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("studentFile/info")
    Call<ApiModel<String>> getStudentFileInfo(@Field("stu_id") String stuId);

    /**
     * 保存高中学校
     *
     * @param stuId      学生id 必传
     * @param schoolId   高中学校id 必传
     * @param schoolName 高中学校 必传
     * @param province   省份编码 必传
     * @param city       城市编码 必传
     * @param area       地区编码 必传
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("studentFile/saveHighschool")
    Call<ApiModel<String>> saveHighschool(@Field("stu_id") String stuId, @Field("school_id") String schoolId,
                                                @Field("school_name") String schoolName, @Field("province") String province,
                                                @Field("city") String city, @Field("area") String area);

    /**
     * 保存留学意向
     *
     * @param stuId        学生id
     * @param targetAbroad 目标国家
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("studentFile/saveHighschool")
    Call<ApiModel<String>> saveHighschool(@Field("stu_id") int stuId, @Field("target_abroad") String targetAbroad);


}
