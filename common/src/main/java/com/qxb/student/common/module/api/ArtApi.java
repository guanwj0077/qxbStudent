package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.ArtApply;
import com.qxb.student.common.module.bean.ArtCase;
import com.qxb.student.common.module.bean.ArtCourse;
import com.qxb.student.common.module.bean.ArtMajor;
import com.qxb.student.common.module.bean.ArtNews;
import com.qxb.student.common.module.bean.ArtNewsBanner;
import com.qxb.student.common.module.bean.ArtNewsComment;
import com.qxb.student.common.module.bean.ArtPhoto;
import com.qxb.student.common.module.bean.ArtSchoolBaseinfo;
import com.qxb.student.common.module.bean.ArtSchoolRecruitData;
import com.qxb.student.common.module.bean.ArtTeacher;
import com.qxb.student.common.module.bean.SchoolNews;
import com.qxb.student.common.module.bean.SysGroup;
import com.qxb.student.common.module.bean.SysStaff;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 艺考
 */
public interface ArtApi {

    /**
     * 艺考资讯banner
     *
     * @return
     */
    @FormUrlEncoded
    @POST("artnews/cycleImg")
    Call<ApiModel<List<ArtNewsBanner>>> artCycleImg();

    /**
     * 艺考招生-专业培训banner
     *
     * @return
     */
    @FormUrlEncoded
    @POST("artnews/trainimg")
    Call<ApiModel<List<ArtNewsBanner>>> artTrainImg();

    /**
     * 艺考-艺考资讯列表接口
     *
     * @param newsType 资讯类型（1：录取规则2：招生简章3：艺考百科4：历年真题5：艺考资讯6：资讯广告）
     * @param stuId    学生id
     * @param keyword  关键字  按标题或简介模糊搜索
     * @param page
     * @param rows     默认10
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("artnews/artList")
    Call<ApiModel<List<ArtNews>>> artNewsList(@Field("news_type") String newsType, @Field("stu_id") String stuId, @Field("keyword") String keyword,
                                                    @Field("page") String page, @Field("rows") String rows);

    /**
     * 艺考-艺考资讯详情
     *
     * @param newsId
     * @param stuId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("artnews/artDetail")
    Call<ApiModel<ArtNews>> artNewsDetail(@Field("art_id") String newsId, @Field("stu_id") String stuId);

    /**
     * 艺考-艺术院校库
     *
     * @param conditionMap s_province  学生省份（必传）
     *                     province 学校省份
     *                     tags     学校类型（标签）
     *                     （--8大传媒   c001
     *                     --9大美院   m001
     *                     --9大音乐   y001
     *                     --31所独立  d001
     *                     --13所参照  z001）
     *                     art_category_code 专业方向
     *                     is_exam  是否校考，写死（""：是否参加校考 "1"：是 "0"：否）
     *                     school_name：学校名称
     *                     page    页码 默认1
     *                     rows 每页大小 默认 10
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("art/school/list")
    Call<ApiModel<List<ArtSchoolBaseinfo>>> artSchoolList(@FieldMap Map<String, Object> conditionMap);

    /**
     * 艺考-艺术热门院校
     *
     * @param sProvince 学生省份
     * @param page
     * @param rows      默认10
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("art/school/topList")
    Call<ApiModel<ArtNews>> artHotSchoolList(@Field("s_province") String sProvince, @Field("page") String page, @Field("rows") String rows);

    /**
     * 艺考-艺术院校tag标签
     *
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("art/school/tagList")
    Call<ApiModel<String>> artSchoolTagList();

    /**
     * 艺考-学校专业方向列表
     *
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("art/school/majorCategory")
    Call<ApiModel<String>> artSchoolMajorCategory();

    /**
     * 艺考-艺考资讯评论列表
     *
     * @param artNewsId 艺考资讯id
     * @param studentId
     * @param page
     * @param rows      默认10
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("artnews/commentList")
    Call<ApiModel<List<ArtNewsComment>>> artNewCommentList(@Field("art_news_id") String artNewsId, @Field("student_id") String studentId, @Field("page") String page, @Field("rows") String rows);

    /**
     * 艺考-艺考资讯评论
     *
     * @param artNewsId 艺考资讯id
     * @param studentId 学生id
     * @param content   评论内容
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("artnews/review")
    Call<ApiModel<String>> artNewReview(@Field("art_news_id") String artNewsId, @Field("stu_id") String studentId, @Field("content") String content);

    /**
     * 艺考-智能选校
     *
     * @param conditionMap stu_id：考生id（必传）
     *                     stu_addr：考生生源地（必传）
     *                     school_addr：高校所在地
     *                     major：专业
     *                     school_type：高校性质
     *                     enroll_rule：招生规则
     *                     culture_score：文化分
     *                     major_score：专业分
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("art/school/autoSelectSchool")
    Call<ApiModel<String>> artSelectSchool(@FieldMap Map<String, Object> conditionMap);

    /**
     * 艺考-院校首页录取数据
     *
     * @param province        省份
     * @param schoolId        学校id
     * @param artCategoryCode 专业大类
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("art/school/recruitData")
    Call<ApiModel<ArtSchoolRecruitData>> schoolRecruitData(@Field("province") String province, @Field("school_id") String schoolId, @Field("art_category_code") String artCategoryCode);

    /**
     * 艺考-院校首页基本信息
     *
     * @param studentId
     * @param schoolId
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("art/school/head")
    Call<ApiModel<ArtSchoolBaseinfo>> artSchoolDetail(@Field("student_id") String studentId, @Field("school_id") String schoolId);

    /**
     * 艺考-院校专业详情
     *
     * @param artMajorId
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("art/school/majorDetail")
    Call<ApiModel<ArtMajor>> artSchoolMajorDetail(@Field("id") String artMajorId);

    /**
     * 艺考-艺考资讯评论点赞
     *
     * @param artNewsId 艺考资讯id
     * @param stuId
     * @param commentId 评论id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("artnews/praise")
    Call<ApiModel<String>> artNewsPraise(@Field("art_news_id") String artNewsId, @Field("stu_id") String stuId, @Field("comment_id") String commentId);

    /**
     * 艺考-艺考资讯评论取消点赞
     *
     * @param artNewsId 艺考资讯id
     * @param stuId
     * @param commentId 评论id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("artnews/cancelPraise")
    Call<ApiModel<String>> artNewsCancelPraise(@Field("art_news_id") String artNewsId, @Field("stu_id") String stuId, @Field("comment_id") String commentId);

    /**
     * 艺考-院校首页招生简章列表
     *
     * @param schoolId
     * @param page
     * @param rows     默认10
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("art/school/generalRules")
    Call<ApiModel<List<SchoolNews>>> getArtSchoolGeneralRuleList(@Field("school_id") String schoolId, @Field("page") String page, @Field("rows") String rows);

    /**
     * 艺考-院校首页录取规则列表
     *
     * @param schoolId
     * @param page
     * @param rows     默认10
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("art/school/enrollRule")
    Call<ApiModel<List<SchoolNews>>> getArtSchoolEnrollRuleList(@Field("school_id") String schoolId, @Field("page") String page, @Field("rows") String rows);

    /**
     * 艺考-院校首页学校概况
     *
     * @param schoolId
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("art/school/remark")
    Call<ApiModel<String>> getArtSchoolRemark(@Field("school_id") String schoolId);

    /**
     * 艺考-专业培训-老师/机构 列表搜索
     *
     * @param searchType      搜索类型  1.找老师   2.找机构  （必传）
     * @param searchCondition 搜索条件  1.离我最近 2.人气最高  （必传）
     * @param areaCode        学生所在区域编码 （必填）
     * @param categoryCode    专业方向
     * @param page
     * @param rows            默认10
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("art/train/list")
    Call<ApiModel<List<ArtTeacher>>> getArtTrainList(@Field("searchType") String searchType, @Field("searchCondition") String searchCondition,
                                                           @Field("area_code") String areaCode, @Field("category_code") String categoryCode,
                                                           @Field("page") String page, @Field("rows") String rows);

    /**
     * 艺考-专业培训-老师/机构 详情
     *
     * @param id        机构或老师id(必传)
     * @param studentId 学生id(必传)
     * @param type      搜索类型  1.找老师 2.找机构(必传)
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("art/train/details")
    Call<ApiModel<ArtTeacher>> getArtTrainDetail(@Field("id") String id, @Field("student_id") String studentId, @Field("type") String type);

    /**
     * 艺考-专业培训-老师/机构 相册
     *
     * @param id   老师或机构id
     * @param type 类型 老师1，机构2
     * @param page
     * @param rows 默认10
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("group/photoList")
    Call<ApiModel<List<ArtPhoto>>> groupPhotoList(@Field("id") String id, @Field("type") String type,
                                                        @Field("page") String page, @Field("rows") String rows);

    /**
     * 艺考-专业培训-老师/机构 教学案例列表
     *
     * @param id   老师或机构id
     * @param type 类型 老师1，机构2
     * @param page
     * @param rows 默认10
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("group/caseList")
    Call<ApiModel<List<ArtCase>>> groupCaseList(@Field("id") String id, @Field("type") String type,
                                                      @Field("page") String page, @Field("rows") String rows);

    /**
     * 艺考-专业培训-老师/机构 开办课程
     *
     * @param id   老师或机构id
     * @param type 类型 老师1，机构2
     * @param page
     * @param rows 默认10
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("group/courseList")
    Call<ApiModel<List<ArtCourse>>> groupCourseList(@Field("id") String id, @Field("type") String type,
                                                          @Field("page") String page, @Field("rows") String rows);

    /**
     * 艺考-专业培训-课程详情
     *
     * @param id 课程id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("group/courseDetail")
    Call<ApiModel<ArtCourse>> groupCourseDetail(@Field("id") String id);

    /**
     * 艺考-专业培训-课程报名
     *
     * @param studentId 学生id （必传）
     * @param courseId  课程id（课程详情返回id）（必传）
     * @param type      类型 1机构 2老师 （课程详情返回type）（必传）
     * @param itemId    机构/老师id（课程详情返回item_id）（必传）
     * @param number    课程数量（必传）
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("group/course/apply")
    Call<ApiModel<String>> groupCourseApply(@Field("student_id") String studentId, @Field("course_id") String courseId,
                                                  @Field("type") String type, @Field("item_id") String itemId, @Field("number") String number);

    /**
     * 艺考-我的课程报名详情
     *
     * @param studentId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("group/course/applyDetails")
    Call<ApiModel<List<ArtApply>>> getMyGroupCourseApply(@Field("student_id") String studentId);

    /**
     * 艺考老师列表
     *
     * @param page
     * @param rows 默认10
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("org/product/artTeacher")
    Call<ApiModel<List<SysStaff>>> getArtTeacherList(@Field("page") String page, @Field("rows") String rows);

    /**
     * 艺考-案例详情
     *
     * @param caseId 案例id
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("group/caseDetail")
    Call<ApiModel<ArtCase>> getGroupCaseDetail(@Field("id") String caseId);

    /**
     * 艺考招生热门名师榜
     *
     * @param province 学生省份（必传，但并未分省）
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("art/teacherRank")
    Call<ApiModel<List<ArtTeacher>>> getArtTeacherRankList(@Field("province") String province);

    /**
     * 艺考-智能选校说明文字
     *
     * @return
     */
    @FormUrlEncoded
    @POST("art/school/autoSelectSchoolExplain")
    Call<ApiModel<String>> getAutoSelectSchoolExplain();

    /**
     * 艺考-查看上次选校结果--返回模型很复杂，需作调整
     *
     * @param stuId       学生id
     * @param stuProvince 学生生源地省份
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("art/school/historySchool")
    Call<ApiModel<String>> getArtHistorySchoolList(@Field("stu_id") String stuId, @Field("stu_addr") String stuProvince);

    /**
     * 艺考-优秀机构榜
     *
     * @param province 学生省份（必传，但并未分省）
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("group/groupRank")
    Call<ApiModel<List<SysGroup>>> getArtGroupRankList(@Field("province") String province);

}
