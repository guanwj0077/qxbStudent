package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.StuScore;
import com.qxb.student.common.module.bean.StudentWish;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 学生
 */
public interface UserStudentApi {

    /**
     * 保存准考证号报名号
     * @param stuId
     * @param ticketno
     * @param baominghao
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("userStudent/saveBaomingTicket")
    Observable<ApiModel<String>> saveBaomingTicket(@Query("id") String stuId,@Query("ticketno") String ticketno,@Query("baominghao") String baominghao);

    /**
     * 修改保存文理科目
     * @param stuId 学生id
     * @param subject 1：文科  2：理科
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("userStudent/saveSubject")
    Observable<ApiModel<String>> saveSubject(@Query("id") String stuId,@Query("sub") String subject);

    /**
     * 修改地区高中
     * @param stuId
     * @param province
     * @param city
     * @param area
     * @param highschoolId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("userStudent/saveArea")
    Observable<ApiModel<String>> saveArea(@Query("id") String stuId,@Query("province") String province,@Query("city") String city,@Query("area") String area,@Query("highschoolId") String highschoolId);

    /**
     * 普通院校新增预报名
     * @param studentId
     * @param schoolId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("studentRegistration/save")
    Observable<ApiModel<String>> saveStudentRegistration(@Query("student_id") String studentId,@Query("school_id") String schoolId);

    /**
     * 单招登记
     * @param studentId
     * @param schoolId
     * @param relationType (单招默认传1)
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("collegeStuRelation/save")
    Observable<ApiModel<String>> saveCollegeStuRelation(@Query("stu_id") String studentId,@Query("school_id") String schoolId,@Query("relation_type") String relationType);

    /**
     * 查询学生的分数列表
     * @param studentId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("stuScore/getList")
    Observable<ApiModel<List<StuScore>>> getStuScoreList(@Query("stu_id") String studentId);

    /**
     * 保存学生的分数
     * @param studentId
     * @param typeId 分数类型ID
     * @param score
     * @param type 类型（必传）1：预估分 2：高考分
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("stuScore/saveScore")
    Observable<ApiModel<String>> saveStuScore(@Query("stu_id") String studentId,@Query("type_id") String typeId,@Query("score") String score,@Query("type") String type);

    /**
     * 获取智能选校分数(获取学生的最近一次根据考试类型倒序排的分数记录)
     * @param studentId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("stuScore/getScore")
    Observable<ApiModel<StuScore>> getStuScore(@Query("stu_id") String studentId);

    /**
     * 我的志愿表数量
     * @param studentId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("wish/myWishTableCount")
    Observable<ApiModel<String>> myWishTableCount(@Query("stu_id") String studentId);

    /**
     * 我的志愿表
     * @param studentId
     * @param page
     * @param rows
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("wish/myWishTables")
    Observable<ApiModel<List<StudentWish>>> myWishTables(@Query("stu_id") String studentId, @Query("page") String page, @Query("rows") String rows);

    /**
     * 查看志愿表详情
     * @param studentId 学生id
     * @param wishId 志愿表id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("wish/wishDetail")
    Observable<ApiModel<StudentWish>> wishDetail(@Query("stu_id") String studentId, @Query("wish_id") String wishId);

    /**
     * 删除志愿表
     * @param studentId 学生id
     * @param wishId 志愿表id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("wish/delWishTable")
    Observable<ApiModel<String>> delWishTable(@Query("stu_id") String studentId, @Query("wish_id") String wishId);

    /**
     * 保存志愿表
     * @param studentId 学生id
     * @param wishTableJson 志愿表json
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("wish/saveWishTable")
    Observable<ApiModel<String>> saveWishTable(@Query("stu_id") String studentId, @Query("wish_table_json") String wishTableJson);

    /**
     * 智能填报志愿
     * @param studentId 学生id
     * @param score 分数
     * @param fillCondition json字符串{"careers"：[{}],"provinces"：[{"province"："000000","province_name"："无所谓 "}]}
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("wish/insightFillWishTable")
    Observable<ApiModel<StudentWish>> insightFillWishTable(@Query("stu_id") String studentId,@Query("score")String score, @Query("fill_condition") String fillCondition);


}
