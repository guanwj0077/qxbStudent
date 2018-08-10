package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.BaseHighSchool;
import com.qxb.student.common.module.bean.CollegeMajorRecruit;
import com.qxb.student.common.module.bean.CollegeQuestion;
import com.qxb.student.common.module.bean.CollegeSearchHot;
import com.qxb.student.common.module.bean.MajorSubject;
import com.qxb.student.common.module.bean.RecomSchool;
import com.qxb.student.common.module.bean.SchoolDetail;
import com.qxb.student.common.module.bean.SchoolVideo;
import com.qxb.student.common.module.bean.ScoreSubject;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SchoolApi {

    /**
     * 获取首页推荐院校列表
     *
     * @param provinceCode
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("school/listIndex")
    Call<ApiModel<List<RecomSchool>>> getRecommendedCollegeList(@Field("province") String provinceCode);

    /**
     * 获取志愿信息
     *
     * @param id       学校专业信息
     * @param stuId
     * @param province 招生省份
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("school/getSchoolProfessNew")
    Call<ApiModel<CollegeMajorRecruit>> getSchoolProfessNew(@Field("id") String id, @Field("stu_id") String stuId, @Field("province") String province);

    /**
     * 根据省市区获得高中学校列表
     *
     * @param province 省份编码
     * @param city     城市编码
     * @param area     地区编码
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("base/highschoollistByCode")
    Call<ApiModel<List<BaseHighSchool>>> highschoollistByCode(@Field("province") String province, @Field("city") String city, @Field("area") String area);

    /**
     * 查询学校列表
     *
     * @param rows       每页行数 默认10
     * @param page       当前页数 默认 1
     * @param schoolName 学校名称
     * @param province   院校所在的省份编码
     * @param city       院校所在的城市编码
     * @param tag        院校的标签
     * @param type       类别(本科/专科)
     * @param stipend    助学卡金额
     * @param status     状态
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("school/list")
    Call<ApiModel<List<RecomSchool>>> getSchoolList(@Field("rows") String rows, @Field("page") String page, @Field("school_name") String schoolName,
                                                    @Field("province") String province, @Field("city") String city, @Field("tag") String tag,
                                                    @Field("type") String type, @Field("stipend") String stipend, @Field("status") String status);

    /**
     * 根据学校名称搜索学校
     *
     * @param schoolName
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("school/searchSchool")
    Call<ApiModel<List<RecomSchool>>> getSearchSchool(@Field("school_name") String schoolName);

    /**
     * 大学详情页
     *
     * @param school_id
     * @param student_id
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("school/getSchoolById")
    Call<ApiModel<SchoolDetail>> getSchoolById(@Field("school_id") String school_id, @Field("student_id") String student_id);

    /**
     * 学校分数线
     *
     * @param schoolId
     * @param province
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("school/scorelist_new")
    Call<ApiModel<List<ScoreSubject>>> getSchoolScore(@Field("school_id") String schoolId, @Field("province") String province);

    /**
     * 学校在招专业
     *
     * @param schoolId
     * @param province
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("school/recruitMajorList_new")
    Call<ApiModel<List<MajorSubject>>> getSchoolRecruitMajor(@Field("school_id") String schoolId, @Field("province") String province);

    /**
     * 获取每个省份大学的个数
     *
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("school/provincelist")
    Call<ApiModel<String>> provinceList();

    /**
     * 通过专业查询学校
     *
     * @param studentId
     * @param profess     专业编码
     * @param subjectType
     * @param province
     * @param page
     * @param rows        默认20
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("school/listbyprofess")
    Call<ApiModel<List<RecomSchool>>> getSchoolListByProfess(@Field("student_id") String studentId, @Field("profess") String profess, @Field("subject_type") String subjectType,
                                                             @Field("province") String province, @Field("page") String page, @Field("rows") String rows);


    /**
     * 学校排行榜
     *
     * @param page
     * @param rows 默认20
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("school/hotlist")
    Call<ApiModel<List<RecomSchool>>> getHotCollegeList(@Field("page") String page, @Field("rows") String rows);

    /**
     * 获取预报名活动院校列表，分省显示
     *
     * @param studentId
     * @param province
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("school/signUpList")
    Call<ApiModel<List<RecomSchool>>> getSchoolSignUpList(@Field("student_id") String studentId, @Field("province") String province);

    /**
     * 获取预报名的banner图片
     *
     * @return
     */
    @FormUrlEncoded
    @POST("school/signUpList")
    Call<ApiModel<String>> getSchoolSignUpBanner();

    /**
     * 我的收藏(关注)学校列表
     *
     * @param studentId
     * @param page
     * @param rows      默认20
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("school/attlist")
    Call<ApiModel<List<RecomSchool>>> getSchoolAttList(@Field("student_id") String studentId, @Field("page") String page, @Field("rows") String rows);

    /**
     * 我的预报名(登记)学校列表
     *
     * @param studentId
     * @param page
     * @param rows      默认20
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("school/reglist")
    Call<ApiModel<List<RecomSchool>>> getSchoolRegList(@Field("student_id") String studentId, @Field("page") String page, @Field("rows") String rows);

    /**
     * 院校库条件(院校库页面信息，包含院校库标签，批次，省份，本省置顶)
     *
     * @param province 学生所在省份
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("schoolLibPage")
    Call<ApiModel<String>> schoolLibPage(@Field("province") String province);

    /**
     * 查询学校列表
     *
     * @param schoolName   学校名称
     * @param province     院校所在的省份编码
     * @param tag          院校的标签
     * @param status       状态
     * @param categoryCode 专业大类
     * @param rProvince    招生省份
     * @param bat          招生批次
     * @param subjectType
     * @return 科目类型 1：文科 2：理科
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("school/search")
    Call<ApiModel<List<RecomSchool>>> schoolSearch(@Field("school_name") String schoolName, @Field("province") String province,
                                                   @Field("tag") String tag, @Field("status") String status,
                                                   @Field("category_code") String categoryCode, @Field("rprovince") String rProvince,
                                                   @Field("bat") String bat, @Field("subject_type") String subjectType);

    /**
     * 取系统配置985,211等学校标签名字解释
     *
     * @param tag_code
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("school/tag")
    Call<ApiModel<String>> schoolTag(@Field("tag_code") String tag_code);

    /**
     * 大学常见问题列表
     * <p>
     * schoolId
     * enrollType 招生类型 1：普招 2：自招
     * title      问题标题
     * page
     * rows       默认10
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("school/questionList")
    Call<ApiModel<List<CollegeQuestion>>> schoolQuestionList(@FieldMap Map<String, String> params);

    /**
     * 大学常见问题详情
     *
     * @param questionId
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("school/questionDetail")
    Call<ApiModel<CollegeQuestion>> schoolQuestionDetail(@Field("id") String questionId);

    /**
     * 手机咨询会-查询参会院校
     *
     * @param searchType 1：参会院校   2：热门院校   默认查询参会院校
     * @param schoolType 1：本科学校  2：专科学校  不传表示全部
     * @param province   学校所在的省份
     * @param page
     * @param rows       默认10
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("mettingschool/search")
    Call<ApiModel<List<CollegeQuestion>>> mettingSchoolSearch(@Field("search_type") String searchType, @Field("school_type") String schoolType, @Field("province") String province,
                                                              @Field("page") String page, @Field("rows") String rows);

    /**
     * 热门院校搜索
     *
     * @param recruitType 默认1 非必传 1,普通招生;2,自主招生
     * @param page
     * @param rows        默认20
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("school/searchHotList")
    Call<ApiModel<List<CollegeSearchHot>>> searchHotSchoolList(@Field("recruit_type") String recruitType,
                                                               @Field("page") String page, @Field("rows") String rows);

    /**
     * 在招院校
     *
     * @param majorType   专业类别（1:本科 2:专科）
     * @param majorName   专业名称
     * @param subjectType 1：文科 2：理科
     * @param province    省份，默认湖北省
     * @param page
     * @param rows        默认20
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("school/recruitList")
    Call<ApiModel<List<RecomSchool>>> schoolRecruitList(@Field("major_type") String majorType, @Field("major_name") String majorName,
                                                        @Field("subject_type") String subjectType, @Field("province") String province,
                                                        @Field("page") String page, @Field("rows") String rows);


    /**
     * 获取学校视频列表
     *
     * @param schoolId 学校id
     * @param rows     一页加载条数
     * @param page     页码
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("article/schoolvideo/list")
    Call<ApiModel<List<SchoolVideo>>> schoolVideoList(@Field("school_id") String schoolId, @Field("rows") String rows, @Field("page") String page);
}
