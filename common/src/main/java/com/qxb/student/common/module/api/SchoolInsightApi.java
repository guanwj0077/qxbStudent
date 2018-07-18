package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.SchoolInsight;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 智能选校
 * @author
 */
public interface SchoolInsightApi {

    /**
     * 智能选校获取学校列表
     * @param ids 学校id，多个由逗号隔开
     * @param province 学校的所在地省份,多个由逗号隔开
     * @param sprovince 用户当前的省份
     * @param profess 专业编码
     * @param page
     * @param rows
     * @return
     */
    @POST("school/listbyids_new")
    Observable<ApiModel<List<SchoolInsight>>> schoolInsightGetList(@Query("ids") String ids, @Query("province") String province, @Query("sprovince") String sprovince, @Query("profess") String profess, @Query("page") String page, @Query("rows") String rows);

    /**
     * 智能选校获取学校ID列表(新接口)
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
    @POST("school/insightscore_new")
    Observable<ApiModel<String>> schoolInsightScoreGetList(@Query("student_id") String studentId, @Query("province") String province, @Query("score_type") String scoreType, @Query("score") String score,
                                                                        @Query("subject_type") String subjectType,@Query("precedence")String precedence,@Query("rtime") String rtime,@Query("rcode") String rcode);



}
