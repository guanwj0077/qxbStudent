package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.StuScore;
import com.qxb.student.common.module.bean.StudentWish;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 学生
 */
public interface UserStudentApi {

    /**
     * 保存准考证号报名号
     *
     * @param stuId
     * @param ticketno
     * @param baominghao
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("userStudent/saveBaomingTicket")
    Observable<ApiModel<String>> saveBaomingTicket(@Field("id") String stuId, @Field("ticketno") String ticketno, @Field("baominghao") String baominghao);

    /**
     * 修改保存文理科目
     *
     * @param stuId   学生id
     * @param subject 1：文科  2：理科
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("userStudent/saveSubject")
    Observable<ApiModel<String>> saveSubject(@Field("id") String stuId, @Field("sub") String subject);

    /**
     * 修改地区高中
     *
     * @param stuId
     * @param province
     * @param city
     * @param area
     * @param highschoolId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("userStudent/saveArea")
    Observable<ApiModel<String>> saveArea(@Field("id") String stuId, @Field("province") String province, @Field("city") String city, @Field("area") String area, @Field("highschoolId") String highschoolId);

    /**
     * 普通院校新增预报名
     *
     * @param studentId
     * @param schoolId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("studentRegistration/save")
    Observable<ApiModel<String>> saveStudentRegistration(@Field("student_id") String studentId, @Field("school_id") String schoolId);

    /**
     * 单招登记
     *
     * @param studentId
     * @param schoolId
     * @param relationType (单招默认传1)
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("collegeStuRelation/save")
    Observable<ApiModel<String>> saveCollegeStuRelation(@Field("stu_id") String studentId, @Field("school_id") String schoolId, @Field("relation_type") String relationType);

    /**
     * 查询学生的分数列表
     *
     * @param studentId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("stuScore/getList")
    Observable<ApiModel<List<StuScore>>> getStuScoreList(@Field("stu_id") String studentId);

    /**
     * 保存学生的分数
     *
     * @param studentId
     * @param typeId    分数类型ID
     * @param score
     * @param type      类型（必传）1：预估分 2：高考分
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("stuScore/saveScore")
    Observable<ApiModel<String>> saveStuScore(@Field("stu_id") String studentId, @Field("type_id") String typeId, @Field("score") String score, @Field("type") String type);

    /**
     * 获取智能选校分数(获取学生的最近一次根据考试类型倒序排的分数记录)
     *
     * @param studentId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("stuScore/getScore")
    Observable<ApiModel<StuScore>> getStuScore(@Field("stu_id") String studentId);

    /**
     * 我的志愿表数量
     *
     * @param studentId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("wish/myWishTableCount")
    Observable<ApiModel<String>> myWishTableCount(@Field("stu_id") String studentId);

    /**
     * 我的志愿表
     *
     * @param studentId
     * @param page
     * @param rows
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("wish/myWishTables")
    Observable<ApiModel<List<StudentWish>>> myWishTables(@Field("stu_id") String studentId, @Field("page") String page, @Field("rows") String rows);

    /**
     * 查看志愿表详情
     *
     * @param studentId 学生id
     * @param wishId    志愿表id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("wish/wishDetail")
    Observable<ApiModel<StudentWish>> wishDetail(@Field("stu_id") String studentId, @Field("wish_id") String wishId);

    /**
     * 删除志愿表
     *
     * @param studentId 学生id
     * @param wishId    志愿表id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("wish/delWishTable")
    Observable<ApiModel<String>> delWishTable(@Field("stu_id") String studentId, @Field("wish_id") String wishId);

    /**
     * 保存志愿表
     *
     * @param studentId     学生id
     * @param wishTableJson 志愿表json
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("wish/saveWishTable")
    Observable<ApiModel<String>> saveWishTable(@Field("stu_id") String studentId, @Field("wish_table_json") String wishTableJson);

    /**
     * 智能填报志愿
     *
     * @param studentId     学生id
     * @param score         分数
     * @param fillCondition json字符串{"careers"：[{}],"provinces"：[{"province"："000000","province_name"："无所谓 "}]}
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("wish/insightFillWishTable")
    Observable<ApiModel<StudentWish>> insightFillWishTable(@Field("stu_id") String studentId, @Field("score") String score, @Field("fill_condition") String fillCondition);


}
