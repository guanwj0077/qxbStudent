package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.CollegeQuestion;
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

    /**
     * 我的收藏(关注)学校列表
     * @param studentId
     * @param page
     * @param rows 默认20
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("school/attlist")
    Observable<ApiModel<List<School>>> getSchoolAttList(@Query("student_id") String studentId,@Query("page")String page,@Query("rows")String rows);

    /**
     * 我的预报名(登记)学校列表
     * @param studentId
     * @param page
     * @param rows 默认20
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("school/reglist")
    Observable<ApiModel<List<School>>> getSchoolRegList(@Query("student_id") String studentId,@Query("page")String page,@Query("rows")String rows);

    /**
     * 院校库条件(院校库页面信息，包含院校库标签，批次，省份，本省置顶)
     * @param province 学生所在省份
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("schoolLibPage")
    Observable<ApiModel<String>> schoolLibPage(@Query("province") String province);

    /**
     * 查询学校列表
     * @param schoolName 学校名称
     * @param province 院校所在的省份编码
     * @param tag 院校的标签
     * @param status 状态
     * @param categoryCode 专业大类
     * @param rProvince 招生省份
     * @param bat 招生批次
     * @param subjectType
     * @return 科目类型 1：文科 2：理科
     */
    @Headers(Config.AUTH_COMMON)
    @POST("school/search")
    Observable<ApiModel<List<School>>> schoolSearch(@Query("school_name") String schoolName, @Query("province") String province,
                                              @Query("tag") String tag, @Query("status") String status,
                                              @Query("category_code") String categoryCode, @Query("rprovince") String rProvince,
                                              @Query("bat") String bat, @Query("subject_type") String subjectType);

    /**
     * 取系统配置985,211等学校标签名字解释
     * @param tag_code
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("school/tag")
    Observable<ApiModel<String>> schoolTag(@Query("tag_code") String tag_code);

    /**
     * 大学常见问题列表
     * @param schoolId
     * @param enrollType 招生类型 1：普招 2：自招
     * @param title 问题标题
     * @param page
     * @param rows 默认10
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("school/questionList")
    Observable<ApiModel<List<CollegeQuestion>>> schoolQuestionList(@Query("school_id") String schoolId, @Query("enroll_type") String enrollType, @Query("title") String title,
                                                                   @Query("page")String page, @Query("rows")String rows);

    /**
     * 大学常见问题详情
     * @param questionId
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("school/questionDetail")
    Observable<ApiModel<CollegeQuestion>> schoolQuestionDetail(@Query("id") String questionId);

    /**
     * 手机咨询会-查询参会院校
     * @param searchType 1：参会院校   2：热门院校   默认查询参会院校
     * @param schoolType 1：本科学校  2：专科学校  不传表示全部
     * @param province 学校所在的省份
     * @param page
     * @param rows 默认10
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("mettingschool/search")
    Observable<ApiModel<List<CollegeQuestion>>> mettingSchoolSearch(@Query("search_type") String searchType, @Query("school_type") String schoolType, @Query("province") String province,
                                                                   @Query("page")String page, @Query("rows")String rows);


}
