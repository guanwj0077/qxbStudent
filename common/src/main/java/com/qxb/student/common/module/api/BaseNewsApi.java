package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.Bankao;
import com.qxb.student.common.module.bean.BaseNews;
import com.qxb.student.common.module.bean.BaseNewsComment;
import com.qxb.student.common.module.bean.SchoolDetail;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 伴考、一分一段等资讯
 */
public interface BaseNewsApi {

    /**
     * 新闻详情,返回新闻实体
     *
     * @param newsId
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("base/newsDetail")
    Call<ApiModel<BaseNews>> newsDetail(@Field("id") String newsId);

    /**
     * 系统新闻列表
     *
     * @param type      5：一分一段
     * @param province
     * @param title
     * @param studentId
     * @param page
     * @param rows      默认20
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("base/newslist")
    Call<ApiModel<List<BaseNews>>> newslist(@Field("type") String type, @Field("province") String province, @Field("title") String title, @Field("student_id") String studentId, @Field("page") String page, @Field("rows") String rows);

    /**
     * 根据id查询系统新闻的详情,返回网页
     *
     * @param newsId
     * @return
     */
    @FormUrlEncoded
    @POST("view/news/detail")
    Call<String> viewNewsDetail(@Field("id") String newsId);

    /**
     * 根据伴考ID获取学校信息
     * newsId       伴考id(必传)
     * type         1：伴考 2：系统通知 3：推送消息(必传)
     * tag          新老版本区分标志，新版本传参旧版本不传
     * msgId        推送消息id
     * receiverType 接收消息者类型，1.学生，2老师
     * receiverId   接收消息者id，学生对应user_id,	老师暂无
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("baseNews/connectSchool")
    Call<ApiModel<SchoolDetail>> connectSchool(@FieldMap Map<String, String> conditionMap);

    /**
     * 伴考资讯列表
     *
     * @param conditionMap keyword：伴考文章标题或间接关键字
     *                     province：考生所在省份
     *                     channel： 频道类型 1.资讯2.备考3.报考4.大学5.专业
     *                     stu_id：学生id
     *                     page：当前页数
     *                     rows：每页展示条数
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("b_news/baseNewsList")
    Call<ApiModel<List<Bankao>>> baseNewslist(@FieldMap Map<String, String> conditionMap);

    /**
     * 伴考资讯详情
     *
     * @param newsId 文字id
     * @param stuId  学生id
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("b_news/baseNewsDetail")
    Call<ApiModel<BaseNews>> baseNewsDetail(@Field("news_id") String newsId, @Field("stu_id") String stuId);

    /**
     * 伴考资讯评论
     *
     * @param newsId
     * @param stuId
     * @param content
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("b_news/review")
    Call<ApiModel<String>> baseNewsReview(@Field("base_news_id") String newsId, @Field("stu_id") String stuId, @Field("content") String content);

    /**
     * 伴考资讯评论列表
     *
     * @param newsId    伴考id
     * @param studentId 学生id
     * @param page      页码
     * @param rows      默认10
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("b_news/commentList")
    Call<ApiModel<List<BaseNewsComment>>> getBaseNewsCommentList(@Field("base_news_id") String newsId, @Field("student_id") String studentId, @Field("page") String page, @Field("rows") String rows);

    /**
     * 伴考资讯评论取消点赞
     *
     * @param newsId    资讯id（必传）
     * @param studentId 学生id（必传）
     * @param commentId 评论id（必传）
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("b_news/cancelPraise")
    Call<ApiModel<String>> cancelCommentPraise(@Field("base_news_id") String newsId, @Field("stu_id") String studentId, @Field("comment_id") String commentId);

    /**
     * 伴考资讯评论点赞
     *
     * @param newsId    资讯id（必传）
     * @param studentId 学生id（必传）
     * @param commentId 评论id（必传）
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("b_news/praise")
    Call<ApiModel<String>> commentPraise(@Field("base_news_id") String newsId, @Field("stu_id") String studentId, @Field("comment_id") String commentId);
}
