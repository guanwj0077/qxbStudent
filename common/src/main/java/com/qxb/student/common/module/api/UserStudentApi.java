package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.BaseArea;

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


}
