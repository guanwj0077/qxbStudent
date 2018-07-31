package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.SchoolInsight;
import com.qxb.student.common.module.bean.ScorePart;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 智能选校
 *
 * @author
 */
public interface SchoolInsightApi {

    /**
     * 智能选校获取学校列表
     *
     * @param ids       学校id，多个由逗号隔开
     * @param province  学校的所在地省份,多个由逗号隔开
     * @param sprovince 用户当前的省份
     * @param profess   专业编码
     * @param page
     * @param rows
     * @return
     */
    @FormUrlEncoded
    @POST("school/listbyids_new")
    Call<ApiModel<List<SchoolInsight>>> schoolInsightGetList(@Field("ids") String ids, @Field("province") String province, @Field("sprovince") String sprovince, @Field("profess") String profess, @Field("page") String page, @Field("rows") String rows);

    /**
     * 智能选校获取学校ID列表(新接口)
     *
     * @param studentId
     * @param province
     * @param scoreType
     * @param score
     * @param subjectType
     * @param precedence
     * @param rtime
     * @param rcode
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("school/insightscore_new")
    Call<ApiModel<String>> schoolInsightScoreGetList(@Field("student_id") String studentId, @Field("province") String province, @Field("score_type") String scoreType, @Field("score") String score,
                                                           @Field("subject_type") String subjectType, @Field("precedence") String precedence, @Field("rtime") String rtime, @Field("rcode") String rcode);

    /**
     * 获取近年位次
     *
     * @param score       分数
     * @param province    省份编码
     * @param subjectType 文理科 1文2理
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("stuScore/getPrecedence")
    Call<ApiModel<List<ScorePart>>> getPrecedenceByScore(@Field("score") String score, @Field("province") String province, @Field("subject_type") String subjectType);


}
