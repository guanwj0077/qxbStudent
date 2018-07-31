package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.Expert;
import com.qxb.student.common.module.bean.ExpertOneToOneServiceDetail;
import com.qxb.student.common.module.bean.ExpertQuestion;
import com.qxb.student.common.module.bean.ExpertStuInfo;
import com.qxb.student.common.module.bean.StudentWish;
import com.qxb.student.common.module.bean.SysAd;
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
 * 问专家
 *
 * @author
 */
public interface ExpertApi {


    /**
     * 问专家-首页banner
     *
     * @param province 学生省份
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("expert/bannerList")
    Call<ApiModel<List<SysAd>>> bannerList(@Field("province") String province);

    /**
     * 问专家-专家列表
     *
     * @param province 学生所在省份
     * @param page
     * @param rows     默认10
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/expertList")
    Call<ApiModel<List<Expert>>> expertList(@Field("province") String province, @Field("page") String page, @Field("rows") String rows);

    /**
     * 问专家-专家详情接口
     *
     * @param expertId 专家id
     * @param stuId    学生id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/expertDetail")
    Call<ApiModel<Expert>> expertDetail(@Field("expert_id") String expertId, @Field("stu_id") String stuId);

    /**
     * 问专家-专家热门回答列表
     *
     * @param expertId 专家id
     * @param stuId    学生id
     * @param page
     * @param rows     默认10
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/hotAnswer")
    Call<ApiModel<List<ExpertQuestion>>> expertHotAnswer(@Field("expert_id") String expertId, @Field("stu_id") String stuId, @Field("page") String page, @Field("rows") String rows);

    /**
     * 2.3版本 提交问题
     *
     * @param questionType 1.志愿填报2.自主招生3.艺术招生4.学习指导5.学科专业
     * @param content
     * @param stuId
     * @param expertId
     * @param accountId
     * @param stuProvince
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("new/question/put")
    Call<ApiModel<String>> expertQuestion(@Field("question_type") String questionType, @Field("content") String content,
                                                @Field("stu_id") String stuId, @Field("expert_id") String expertId,
                                                @Field("account_id") String accountId, @Field("stu_province") String stuProvince);

    /**
     * 问答详情
     *
     * @param question_id
     * @param accountId
     * @param stuId
     * @param type        来源 1.列表进入（默认），2.我的订单详情进入|支付进详情
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/new/question/detail")
    Call<ApiModel<ExpertQuestion>> questionDetail(@Field("question_id") String question_id, @Field("account_id") String accountId,
                                                        @Field("stu_id") String stuId, @Field("type") String type);

    /**
     * 1对1志愿填报-评价标签列表-返回Map里有ExpertLabel对象
     *
     * @param answerId 回答id
     * @param expertId
     * @param stuId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/evaluationLabel")
    Call<ApiModel<String>> evaluationLabel(@Field("answer_id") String answerId, @Field("expert_id") String expertId,
                                                 @Field("stu_id") String stuId);

    /**
     * 1对1志愿填报-评价该订单
     *
     * @param conditionMap type：1表示点赞  2表示评星（必传）
     *                     expert_id：专家id（必传）
     *                     stu_id：学生id（必传）
     *                     order_id：订单id（必传）
     *                     label_id_str：标签id（多个用，隔开）
     *                     answer_id：回答id
     *                     star：星级（1,2,3,4,5）
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/expertEvaluation")
    Call<ApiModel<String>> expertEvaluation(@FieldMap Map<String, Object> conditionMap);

    /**
     * 获取客服列表
     *
     * @param type     客服类别（必传）（服务咨询：1 操作指南：2 广告业务：3 商业合作：4 院校入驻：5 用户反馈：6 订单跳转的，传1？）
     * @param province
     * @param page
     * @param rows     默认10
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/getExpertCustomerServiceList")
    Call<ApiModel<List<SysStaff>>> getExpertCustomerServiceList(@Field("type") String type, @Field("province") String province,
                                                                      @Field("page") String page, @Field("rows") String rows);

    /**
     * 问答围观
     *
     * @param accountId
     * @param stuId
     * @param questionId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/look")
    Call<ApiModel<String>> lookQuestion(@Field("account_id") String accountId, @Field("stu_id") String stuId, @Field("question_id") String questionId);

    /**
     * 1对1志愿填报-创建1对1订单
     *
     * @param accountId 学生账户id
     * @param expertId  专家id
     * @param type      （必传）(
     *                  EXPERT_FILL_WISH：  1对1志愿填报线下咨询
     *                  AUTONOMOUS_STUDENT：  1对1自主招生线下咨询
     *                  EXPERT_FILL_WISH_O：  1对1志愿填报线上服务
     *                  AUTONOMOUS_STUDENT_O：  1对1自主招生线上服务
     *                  )
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/createExpertOneToOneOrder")
    Call<ApiModel<String>> createExpertOneToOneOrder(@Field("account_id") String accountId, @Field("expert_id") String expertId, @Field("type") String type);

    /**
     * 取消订单  此处APP接口则为全退
     *
     * @param orderId     订单id（必传）
     * @param refundDescr 退款描述
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/cancelOrder")
    Call<ApiModel<String>> cancelExpertOrder(@Field("order_id") String orderId, @Field("refund_descr") String refundDescr);

    /**
     * 删除订单
     *
     * @param orderId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/deleteOrder")
    Call<ApiModel<String>> deleteExpertOrder(@Field("order_id") String orderId);

    /**
     * 学生档案保存
     *
     * @param conditionNap stu_id 学生id
     *                     name 姓名
     *                     sex 性别 1.男2.女
     *                     subject 科目 1文科 2理科
     *                     years 高考年份
     *                     school_id 学校id
     *                     nation 民族
     *                     target_area 意愿报考地区
     *                     hight 学生身高（int）
     *                     health 学生健康状态(string)
     *                     color_blind是否色盲1.是2.否
     *                     left_eye左眼视力(string)
     *                     right_eye 右眼视力(string)
     *                     is_job 是否任职 1.是2.否
     *                     stu_job 任何职位(string)
     *                     is_extra_score：是否有加分项 1是 2否
     *                     extra_score：额外加分
     *                     qq：qq号
     *                     mother_job：母亲工作
     *                     father_job：父亲工作
     *                     target_college：意向报考院校
     *                     target_majors：意向报考专业
     *                     target_abroad：留学意向
     *                     activityList：社会活动(string)
     *                     awardList：获奖经历(string)
     *                     dissertationList：论文/专刊(string)
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/studentFile/save")
    Call<ApiModel<String>> saveStudentFile(@FieldMap Map<String, Object> conditionNap);

    /**
     * 获取学生档案
     *
     * @param orderId 订单id
     * @param stuId   学生id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/getStudentFile")
    Call<ApiModel<ExpertStuInfo>> getStudentFile(@Field("order_id") String orderId, @Field("stu_id") String stuId);

    /**
     * 学生分数保存/更新
     *
     * @param conditionNap stu_id 学生ID（必传）
     *                     test_type 考试类型 1.模拟 2.高考（必传）
     *                     total 总分
     *                     chinese 语文
     *                     math 数学
     *                     english 英语
     *                     politics 政治
     *                     history 历史
     *                     geography 地理
     *                     physics 物理
     *                     chemistry 化学
     *                     biology 生物
     *                     <p>
     *                     test_date 考试时间
     *                     subject_type 学科类型
     *                     count_people 年级总人数
     *                     rankings 排名
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/studentFileScore/save")
    Call<ApiModel<String>> saveStudentFileScore(@FieldMap Map<String, Object> conditionNap);

    /**
     * 订单详情-返回Map里有Expert对象
     *
     * @param orderId  订单id
     * @param expertId 专家id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/getOrderDetail")
    Call<ApiModel<String>> getOrderDetail(@Field("order_id") String orderId, @Field("expert_id") String expertId);

    /**
     * 1v1服务订单详情
     *
     * @param orderId 订单id（必传）
     * @param stuId   学生id（必传）
     * @param type    （必传）(
     *                EXPERT_FILL_WISH：  1对1志愿填报线下咨询
     *                AUTONOMOUS_STUDENT：  1对1自主招生线下咨询
     *                EXPERT_FILL_WISH_O：  1对1志愿填报线上服务
     *                AUTONOMOUS_STUDENT_O：  1对1自主招生线上服务
     *                )
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/getOneToOneDetail")
    Call<ApiModel<String>> getOneToOneDetail(@Field("order_id") String orderId, @Field("stu_id") String stuId, @Field("type") String type);

    /**
     * 1对1志愿填报-获取志愿草表
     *
     * @param orderId  订单id（必传）
     * @param wishType 志愿类型 （必传）（1.智能填报志愿,2.志愿填报服务草表,3.自主招生服务草表）
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/getWishTable")
    Call<ApiModel<StudentWish>> getWishTable(@Field("order_id") String orderId, @Field("wish_type") String wishType);

    /**
     * 问专家-找专家首页-今日大咖、分类专家列表  （返回Map里包含多个List<Map>)
     *
     * @param province
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/expertListByGoodService")
    Call<ApiModel<String>> getExpertListByGoodService(@Field("province") String province);

    /**
     * 专家主页
     *
     * @param expertId 专家id
     * @param stuId    学生id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/new/home")
    Call<ApiModel<Expert>> getExpertHomeData(@Field("expert_id") String expertId, @Field("stu_id") String stuId);

    /**
     * 专家主页，我的已答问题列表(后台无认证头校验)
     *
     * @param expertId 专家id
     * @param stuId    学生id
     * @param type     问题类型 1.志愿填报2.自主招生3.艺术招生4.学习指导5.学科专业
     * @param page
     * @param rows     默认5
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/new/myAnswerQuestion/list")
    Call<ApiModel<List<ExpertQuestion>>> getExpertAnsweredQuestionList(@Field("expert_id") String expertId, @Field("stu_id") String stuId, @Field("type") String type,
                                                                             @Field("page") String page, @Field("rows") String rows);

    /**
     * 点赞
     *
     * @param answerId 问题答案id
     * @param stuId    学生id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/new/question/praise")
    Call<ApiModel<String>> praiseAnswer(@Field("answer_id") String answerId, @Field("stu_id") String stuId);

    /**
     * 根据问题类型选择专家，返回专家列表
     *
     * @param province 学生省份
     * @param type     问题类型 必传 1.志愿填报2.自主招生3.艺术招生4.学习指导5.学科专业
     * @param page
     * @param rows     默认10
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/new/select")
    Call<ApiModel<List<Expert>>> selectExpertList(@Field("province") String province, @Field("type") String type, @Field("page") String page, @Field("rows") String rows);

    /**
     * 专家 1v1服务详情
     *
     * @param type  1：1v1线上志愿填报   2：1v1线上自主招生
     * @param stuId 学生id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/expertListByTypeOneToOne")
    Call<ApiModel<ExpertOneToOneServiceDetail>> expertListByTypeOneToOne(@Field("type") String type, @Field("stu_id") String stuId);


}
