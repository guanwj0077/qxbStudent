package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.OrgProduct;
import com.qxb.student.common.module.bean.OrgProductDetail;
import com.qxb.student.common.module.bean.SysStaff;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 机构产品
 */
public interface OrgProductApi {

    /**
     * 机构服务列表
     * @param type 类别（必传）(1：艺考培训 2：法国直通车 3：职业技能 4：出国留学)
     * @param ownerId 机构id
     * @param tags 标签
     * @param title 项目名称
     * @param page
     * @param rows
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("org/product/list")
    Observable<ApiModel<List<OrgProduct>>> orgProductList(@Query("type") String type, @Query("owner_id") String ownerId,
                                                         @Query("tags") String tags, @Query("title") String title,
                                                          @Query("page") String page, @Query("rows") String rows);

    /**
     * 机构服务详情
     * @param id 服务项目id
     * @param studentId 学生id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("org/product/detail")
    Observable<ApiModel<OrgProductDetail>> orgProductDetail(@Query("id") String id, @Query("student_id") String studentId);

    /**
     * 机构详情
     * @param owner_id 机构id
     * @param bkzj 报考专家时传该参数(大于0)
     * @param stuId 学生id 非必传
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("org/product/orgDetail")
    Observable<ApiModel<String>> orgDetail(@Query("owner_id") String owner_id, @Query("bkzj") String bkzj,@Query("stu_id") String stuId);

    /**
     * 报考专家与自主招生专家列表新接口 分省份 分类型
     * @param province 省份
     * @param type 类型，默认为1 1：只支持普通招生,2：只支持自主招生,3：支持普通招生且支持自主招生
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("org/product/withSpecialistList")
    Observable<ApiModel<String>> withSpecialistList(@Query("province") String province,@Query("type") String type);

    /**
     * 机构-获取老师列表
     * @param ownerId 机构id
     * @param page
     * @param rows 默认10
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("org/product/orgTeaList")
    Observable<ApiModel<List<SysStaff>>> orgTeaList(@Query("owner_id") String ownerId, @Query("page") String page, @Query("rows") String rows);

    /**
     * 报名机构服务
     * @param orgProductId 服务项目id
     * @param studentId 学生id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("org/product/regist")
    Observable<ApiModel<String>> registOrgProduct(@Query("id") String orgProductId, @Query("student_id") String studentId);

}
