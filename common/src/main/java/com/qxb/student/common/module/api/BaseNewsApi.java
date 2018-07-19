package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.BaseNews;
import com.qxb.student.common.module.bean.NewsConnectInfo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
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
    Observable<ApiModel<BaseNews>> newsDetail(@Field("id") String newsId);

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
    Observable<ApiModel<List<BaseNews>>> newslist(@Field("type") String type, @Field("province") String province, @Field("title") String title, @Field("student_id") String studentId, @Field("page") String page, @Field("rows") String rows);

    /**
     * 根据id查询系统新闻的详情,返回网页
     *
     * @param newsId
     * @return
     */
    @FormUrlEncoded
    @POST("view/news/detail")
    Observable<String> viewNewsDetail(@Field("id") String newsId);

    /**
     * 根据伴考ID获取学校信息
     *
     * @param newsId       伴考id(必传)
     * @param type         1：伴考 2：系统通知 3：推送消息(必传)
     * @param tag          新老版本区分标志，新版本传参旧版本不传
     * @param msgId        推送消息id
     * @param receiverType 接收消息者类型，1.学生，2老师
     * @param receiverId   接收消息者id，学生对应user_id,	老师暂无
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("baseNews/connectSchool")
    Observable<ApiModel<NewsConnectInfo>> connectSchool(@Field("id") String newsId, @Field("type") String type, @Field("tag") String tag,
                                                        @Field("msg_id") String msgId, @Field("receiver_type") String receiverType, @Field("receiver_id") String receiverId);
}
