package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.BaseEvaluationResult;

import java.util.List;

import io.reactivex.Observable;
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
     * @param type 2为霍兰德测试  默认为mbti测试
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("evaluation/getlist")
    Observable<ApiModel<List<String>>> getEvaluationList(@Field("type") String type);

    /**
     * 测评-获取霍兰德测评答题结果
     * @param studentId 学生id
     * @param username 学生姓名
     * @param result 结果
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("evaluation/getResultHolland")
    Observable<ApiModel<String>> getResultHolland(@Field("userid") String studentId,@Field("username") String username,@Field("result") String result);

    /**
     * 测评-获取答题结果
     * @param studentId 学生id
     * @param username 学生姓名
     * @param result 结果
     * @param type 类型 1：本科 2：专科
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("evaluation/getResult")
    Observable<ApiModel<BaseEvaluationResult>> getResult(@Field("userid") String studentId, @Field("username") String username, @Field("result") String result, @Field("type") String type);


}
