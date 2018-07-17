package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.School;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SchoolApi {

    /**
     * 获取首页推荐院校列表
     * @param provinceCode
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("school/listIndex")
    Observable<ApiModel<List<School>>> getRecommendedCollegeList(@Query("province") String provinceCode);

    /**
     * 查询学校列表
     * @param rows 每页行数 默认10
     * @param page 当前页数 默认 1
     * @param schoolName 学校名称
     * @param province 院校所在的省份编码
     * @param city 院校所在的城市编码
     * @param tag 院校的标签
     * @param type 类别(本科/专科)
     * @param stipend 助学卡金额
     * @param status 状态
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("school/list")
    Observable<ApiModel<List<School>>> getSchoolList(@Query("rows") String rows,@Query("page") String page,@Query("school_name") String schoolName,
                                                     @Query("province") String province,@Query("city") String city,@Query("tag") String tag,
                                                     @Query("type") String type,@Query("stipend") String stipend,@Query("status") String status);

    /**
     * 根据学校名称搜索学校
     * @param schoolName
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("school/searchSchool")
    Observable<ApiModel<List<School>>> getSearchSchool(@Query("school_name") String schoolName);

    /**
     * 大学详情页
     * @param school_id
     * @param student_id
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("school/getSchoolById")
    Observable<ApiModel<School>> getSchoolById(@Query("school_id") String school_id,@Query("student_id") String student_id);

    /**
     * 获取每个省份大学的个数
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("school/provincelist")
    Observable<ApiModel<String>> provinceList();

    /**
     * 通过专业查询学校
     * @param studentId
     * @param profess  专业编码
     * @param subjectType
     * @param province
     * @param page
     * @param rows  默认20
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("school/listbyprofess")
    Observable<ApiModel<List<School>>> getSchoolListByProfess(@Query("student_id")String studentId,@Query("profess") String profess,@Query("subject_type")String subjectType,
                                                        @Query("province") String province,@Query("page") String page,@Query("rows")String rows);


    /**
     * 学校排行榜
     * @param page
     * @param rows 默认20
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("school/hotlist")
    Observable<ApiModel<List<School>>> getHotCollegeList(@Query("page") String page,@Query("rows")String rows);

    /**
     * 获取预报名活动院校列表，分省显示
     * @param studentId
     * @param province
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("school/signUpList")
    Observable<ApiModel<List<School>>> getSchoolSignUpList(@Query("student_id") String studentId,@Query("province")String province);

    /**
     * 获取预报名的banner图片
     * @return
     */
    @POST("school/signUpList")
    Observable<ApiModel<String>> getSchoolSignUpBanner();

}
