package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.BaseEvaluationResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 职业性格测评
 */
public interface EvaluationApi {

    /**
     * 测评-获取题库
     *
     * @param type 2为霍兰德测试  默认为mbti测试
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("evaluation/getlist")
    Call<ApiModel<List<String>>> getEvaluationList(@Field("type") String type);

    /**
     * 测评-获取霍兰德测评答题结果
     *
     * @param studentId 学生id
     * @param username  学生姓名
     * @param result    结果
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("evaluation/getResultHolland")
    Call<ApiModel<String>> getResultHolland(@Field("userid") String studentId, @Field("username") String username, @Field("result") String result);

    /**
     * 测评-获取答题结果
     *
     * @param studentId 学生id
     * @param username  学生姓名
     * @param result    结果
     * @param type      类型 1：本科 2：专科
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("evaluation/getResult")
    Call<ApiModel<BaseEvaluationResult>> getResult(@Field("userid") String studentId, @Field("username") String username, @Field("result") String result, @Field("type") String type);

    /**
     * 测评-获取答题结果新接口（去掉 type本专科 、去掉职业推荐）
     *
     * @param studentId
     * @param username
     * @param result
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("evaluation/getResultNew")
    Call<ApiModel<BaseEvaluationResult>> getResultNew(@Field("userid") String studentId, @Field("username") String username, @Field("result") String result);

    /**
     * 测评-获取专业
     *
     * @param studentId stu_id：学生id
     * @param type      类型 单独无意义 当m_table n_table确定之后 才有意义
     *                  如  m_table =base_evaluation_charactertype n_table=t_sys_career type=0表示mbti测评  type=1 表示霍兰德
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("evaluation/getCareer")
    Call<ApiModel<String>> getCareer(@Field("stu_id") String studentId, @Field("type") String type);


}
