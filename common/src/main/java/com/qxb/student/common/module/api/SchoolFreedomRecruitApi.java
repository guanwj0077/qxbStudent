package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.AdFreedom;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.Award;
import com.qxb.student.common.module.bean.BaseSubjectCategory;
import com.qxb.student.common.module.bean.CollegeFreedomMajorRecruit;
import com.qxb.student.common.module.bean.RecomSchool;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 自主招生
 *
 * @author hs011
 */
public interface SchoolFreedomRecruitApi {


    /**
     * 自招-自主招生顶部视频
     *
     * @return
     */

    @FormUrlEncoded
    @POST("freedomRecruit/video")
    Call<ApiModel<String>> freedomRecruitVideo();

    /**
     * 自招-自招院校库
     *
     * @param schoolName      大学名称
     * @param province        省份
     * @param categoryCode    专业
     * @param studentProvince 学生省份
     * @param subjectType     1 文  2 理
     * @param page
     * @param rows            默认10
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("freedomRecruit/school/list")
    Call<ApiModel<List<RecomSchool>>> freedomRecruitSchoolList(@Field("school_name") String schoolName, @Field("province") String province,
                                                                     @Field("category_code") String categoryCode, @Field("student_province") String studentProvince,
                                                                     @Field("subject_type") String subjectType, @Field("page") String page, @Field("rows") String rows);

    /**
     * 自招-通过专业搜索获取在招专业的院校
     *
     * @param province     省份(必传)
     * @param categoryCode 专业编码
     * @param majorName    专业名称
     * @param subjectType  1 文  2 理
     * @param page
     * @param rows         默认10
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("freedomRecruit/searchSchoolByMajor")
    Call<ApiModel<List<CollegeFreedomMajorRecruit>>> searchSchoolByMajor(@Field("province") String province, @Field("category_code") String categoryCode, @Field("major_name") String majorName,
                                                                               @Field("subject_type") String subjectType, @Field("page") String page, @Field("rows") String rows);

    /**
     * 获取在招专业列表
     *
     * @param province
     * @param school_id
     * @param subjectType 1 文  2 理
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("school/majorList_new")
    Call<ApiModel<String>> schoolMajorListNew(@Field("province") String province, @Field("school_id") String school_id,
                                                    @Field("subject_type") String subjectType);

    /**
     * 自招-院校推荐
     *
     * @param awardCode   奖项编码
     * @param province    省份编码
     * @param cCode       学科编码
     * @param subjectType 1 文  2 理
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("freedomRecruit/collegeRecommendation/getSchoolList")
    Call<ApiModel<List<RecomSchool>>> recommendSchoolList(@Field("award_code") String awardCode, @Field("province") String province, @Field("ccode") String cCode,
                                                                @Field("subject_type") String subjectType);

    /**
     * 自招-院校推荐-意向专业查询
     *
     * @param cCode       学科大类编码
     * @param province    省份编码
     * @param subjectType 1 文  2 理
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("freedomRecruit/collegeRecommendation/getSubjectList")
    Call<ApiModel<BaseSubjectCategory>> recommendMajorList(@Field("ccode") String cCode, @Field("province") String province,
                                                                 @Field("subject_type") String subjectType);

    /**
     * 自招-院校推荐-奖项查询
     *
     * @param awardCode
     * @param province
     * @param subjectType
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("freedomRecruit/collegeRecommendation/getAwardList")
    Call<ApiModel<Award>> getAwardList(@Field("award_code") String awardCode, @Field("province") String province,
                                             @Field("subject_type") String subjectType);

    /**
     * 自招首页轮播图
     *
     * @param type 1视屏，0链接
     * @param id   自招广告id
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("freedomRecruit/ad_freedom_list")
    Call<ApiModel<List<AdFreedom>>> adFreedomList(@Field("type") String type, @Field("id") String id);

}
