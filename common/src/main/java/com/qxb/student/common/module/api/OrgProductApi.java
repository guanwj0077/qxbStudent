package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.OrgProduct;
import com.qxb.student.common.module.bean.OrgProductDetail;
import com.qxb.student.common.module.bean.SysStaff;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 机构产品
 */
public interface OrgProductApi {

    /**
     * 机构服务列表
     *
     * @param type    类别（必传）(1：艺考培训 2：法国直通车 3：职业技能 4：出国留学)
     * @param ownerId 机构id
     * @param tags    标签
     * @param title   项目名称
     * @param page
     * @param rows
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("org/product/list")
    Call<ApiModel<List<OrgProduct>>> orgProductList(@Field("type") String type, @Field("owner_id") String ownerId,
                                                    @Field("tags") String tags, @Field("title") String title,
                                                    @Field("page") String page, @Field("rows") String rows);

    /**
     * 机构服务详情
     *
     * @param id        服务项目id
     * @param studentId 学生id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("org/product/detail")
    Call<ApiModel<OrgProductDetail>> orgProductDetail(@Field("id") String id, @Field("student_id") String studentId);

    /**
     * 机构详情
     *
     * @param owner_id 机构id
     * @param bkzj     报考专家时传该参数(大于0)
     * @param stuId    学生id 非必传
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("org/product/orgDetail")
    Call<ApiModel<String>> orgDetail(@Field("owner_id") String owner_id, @Field("bkzj") String bkzj, @Field("stu_id") String stuId);

    /**
     * 报考专家与自主招生专家列表新接口 分省份 分类型
     *
     * @param province 省份
     * @param type     类型，默认为1 1：只支持普通招生,2：只支持自主招生,3：支持普通招生且支持自主招生
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("org/product/withSpecialistList")
    Call<ApiModel<String>> withSpecialistList(@Field("province") String province, @Field("type") String type);

    /**
     * 机构-获取老师列表
     *
     * @param ownerId 机构id
     * @param page
     * @param rows    默认10
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("org/product/orgTeaList")
    Call<ApiModel<List<SysStaff>>> orgTeaList(@Field("owner_id") String ownerId, @Field("page") String page, @Field("rows") String rows);

    /**
     * 报名机构服务
     *
     * @param orgProductId 服务项目id
     * @param studentId    学生id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("org/product/regist")
    Call<ApiModel<String>> registOrgProduct(@Field("id") String orgProductId, @Field("student_id") String studentId);

    /**
     * 机构-获取服务标签
     *
     * @param type 服务类型 1：艺考培训 2：法国直通车 3：职业技能 4：出国留学
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("org/product/tags")
    Call<ApiModel<List<String>>> orgProductTags(@Field("type") String type);

    /**
     * 首页找服务文字接口
     * @param type
     * @return
     */
    @FormUrlEncoded
    @POST("org/serviceName")
    Call<ApiModel<String>> orgServiceName(@Field("type") String type);

    /**
     * 获取老师一对一服务列表
     * @param staffId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("org/product/teacherOneToOne")
    Call<ApiModel<List<String>>> teacherOneToOne(@Field("staff_id") String staffId);

}
