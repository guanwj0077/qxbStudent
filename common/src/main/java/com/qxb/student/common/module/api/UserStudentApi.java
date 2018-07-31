package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.StuScore;
import com.qxb.student.common.module.bean.StudentWish;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
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
    Call<ApiModel<String>> saveBaomingTicket(@Field("id") String stuId, @Field("ticketno") String ticketno, @Field("baominghao") String baominghao);

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
    Call<ApiModel<String>> saveSubject(@Field("id") String stuId, @Field("sub") String subject);

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
    Call<ApiModel<String>> saveArea(@Field("id") String stuId, @Field("province") String province, @Field("city") String city, @Field("area") String area, @Field("highschoolId") String highschoolId);

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
    Call<ApiModel<String>> saveStudentRegistration(@Field("student_id") String studentId, @Field("school_id") String schoolId);

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
    Call<ApiModel<String>> saveCollegeStuRelation(@Field("stu_id") String studentId, @Field("school_id") String schoolId, @Field("relation_type") String relationType);

    /**
     * 查询学生的分数列表
     *
     * @param studentId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("stuScore/getList")
    Call<ApiModel<List<StuScore>>> getStuScoreList(@Field("stu_id") String studentId);

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
    Call<ApiModel<String>> saveStuScore(@Field("stu_id") String studentId, @Field("type_id") String typeId, @Field("score") String score, @Field("type") String type);

    /**
     * 获取智能选校分数(获取学生的最近一次根据考试类型倒序排的分数记录)
     *
     * @param studentId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("stuScore/getScore")
    Call<ApiModel<StuScore>> getStuScore(@Field("stu_id") String studentId);

    /**
     * 我的志愿表数量
     *
     * @param studentId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("wish/myWishTableCount")
    Call<ApiModel<String>> myWishTableCount(@Field("stu_id") String studentId);

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
    Call<ApiModel<List<StudentWish>>> myWishTables(@Field("stu_id") String studentId, @Field("page") String page, @Field("rows") String rows);

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
    Call<ApiModel<StudentWish>> wishDetail(@Field("stu_id") String studentId, @Field("wish_id") String wishId);

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
    Call<ApiModel<String>> delWishTable(@Field("stu_id") String studentId, @Field("wish_id") String wishId);

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
    Call<ApiModel<String>> saveWishTable(@Field("stu_id") String studentId, @Field("wish_table_json") String wishTableJson);

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
    Call<ApiModel<StudentWish>> insightFillWishTable(@Field("stu_id") String studentId, @Field("score") String score, @Field("fill_condition") String fillCondition);

    /**
     * 分享得积分
     *
     * @param accountId 账户id（必传）
     * @param type      类型（必传）（app_share：分享APP article_share：伴考分享）
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("integral/share")
    Call<ApiModel<String>> integralShare(@Field("account_id") String accountId, @Field("type") String type);

    /**
     * 我的积分详情列表
     *
     * @param accountId
     * @param page
     * @param rows
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("integral/record")
    Call<ApiModel<String>> integralRecord(@Field("account_id") String accountId, @Field("page") String page, @Field("rows") String rows);

    /**
     * 活动码-好友激活
     *
     * @param accountId    账户id
     * @param activateCode 激活码
     * @param stuPhone     学生手机号
     * @param appid        设备id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("student/activate")
    Call<ApiModel<String>> studentActivate(@Field("account_id") String accountId, @Field("activate_code") String activateCode,
                                                 @Field("stu_phone") String stuPhone, @Field("appid") String appid);

    /**
     * 活动码-获取学生的已激活信息
     *
     * @param stuId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("student/activateCount")
    Call<ApiModel<String>> studentActivateCount(@Field("stu_id") String stuId);

    /**
     * 活动码-判断学生是否已经激活
     *
     * @param stuPhone 学生手机号
     * @param appid    设备id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("student/isActivated")
    Call<ApiModel<String>> studentIsActivated(@Field("stu_phone") String stuPhone, @Field("appid") String appid);

    /**
     * 获取用户的当前积分,用于刷新我的页面
     *
     * @param accountId 账户id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("integral/student")
    Call<ApiModel<String>> studentIntegral(@Field("account_id") String accountId);

    /**
     * 兑换码兑积分
     *
     * @param accountId    账户id
     * @param activityCode 兑换码
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("integral/activitycode")
    Call<ApiModel<String>> activityCode(@Field("account_id") String accountId, @Field("activity_code") String activityCode);

    /**
     * 修改昵称
     *
     * @param studentId 学生id
     * @param nickName  昵称
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("userStudent/updateNickName")
    Call<ApiModel<String>> updateNickName(@Field("id") String studentId, @Field("nick_name") String nickName);

    /**
     * 查询用户普招院校收藏状态,返回Boolean值 true:已收藏  false：未收藏
     *
     * @param studentId
     * @param schoolId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("studentAttention/query")
    Call<ApiModel<String>> queryStudentAttention(@Field("student_id") String studentId, @Field("school_id") String schoolId);

    /**
     * 分阶段补录信息
     *
     * @param conditionMap id：学生id
     *                     step：补录步骤 1,2,3,4
     *                     province：省份编码
     *                     city：城市编码
     *                     area：地区编码
     *                     highschool_id：高中学校id
     *                     name：学生姓名
     *                     score：最近的分数
     *                     subject_type：文理科 1：理科 2：文科
     *                     sex：1：男 2：女
     *                     years：年份
     *                     is_plan_abroad：是否打算出国 1：是
     *                     continent：意向留学州 1：北美洲 2：欧洲 3：大洋洲 4：亚洲 5：南美洲 6：非洲 7：不想留学
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("userStudent/saveStuInfoNew")
    Call<ApiModel<String>> saveStuInfoNew(@FieldMap Map<String, Object> conditionMap);

}
