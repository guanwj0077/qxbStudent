package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.AbroadActive;
import com.qxb.student.common.module.bean.AbroadAdviser;
import com.qxb.student.common.module.bean.AbroadBaseMajor;
import com.qxb.student.common.module.bean.AbroadEvaluate;
import com.qxb.student.common.module.bean.AbroadGroupCase;
import com.qxb.student.common.module.bean.AbroadMajorRank;
import com.qxb.student.common.module.bean.AbroadNews;
import com.qxb.student.common.module.bean.AbroadNewsDetial;
import com.qxb.student.common.module.bean.AbroadOrder;
import com.qxb.student.common.module.bean.AbroadSchool;
import com.qxb.student.common.module.bean.AbroadSchoolMajor;
import com.qxb.student.common.module.bean.AbroadSchoolRank;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.BaseCodeName;
import com.qxb.student.common.module.bean.ExpertLabel;
import com.qxb.student.common.module.bean.SysGoods;
import com.qxb.student.common.module.bean.SysGroup;
import com.qxb.student.common.module.bean.UserSchoolTeacher;
import com.qxb.student.common.module.bean.abroadGoods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 留学服务
 * @author qianle
 *
 */
public interface AbroadApi {

    /**
     * 留学订单详情
     * @param orderId     订单id
     * @param accountId   账户id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("abroad/order/orderDetail")
    Call<ApiModel<AbroadOrder>> orderDetail(@Field("orderId") int orderId, @Field("accountId") int accountId);


    /**
     * 专家的标签
     * @param accountId  账户id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("abroad/order/labelList")
    Call<ApiModel<ExpertLabel>> labelList(@Field("accountId") int accountId);



    /**
     * 根据资讯类型分页查询资讯
     * @param newsType  资讯类型
     * @param keyword   关键字
     * @param rows      每页大小
     * @param page      页码
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("abroad/news/getList")
    Call<ApiModel<AbroadNews>> newsList(@Field("rows") int rows, @Field("page") int page,@Field("news_type") int newsType, @Field("keyword") String keyword);


    /**
     * 留学资讯banner
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("abroad/news/cycleimg")
    Call<ApiModel<String>> cycleimg();


    /**
     * 根据id获取资讯详情
     * @param id          文章id
     * @param newsType    资讯类型
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("abroad/news/getDetial")
    Call<ApiModel<AbroadNewsDetial>> newsDetial(@Field("id") int id, @Field("news_type") int newsType);

    /**
     *  首页  留学资讯
     * @param rows  每页大小  默认3
     * @param page  页码
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("abroad/news/getTopList")
    Call<ApiModel<List<AbroadNews>>> newsTopList(@Field("rows") int rows, @Field("page") int page);


    /**
     * 获取国家名称及编码列表
     * @return
     */
    @FormUrlEncoded
    @POST("abroad/country/list")
    Call<ApiModel<BaseCodeName>> countryList();


    /**
     * 留学国家查询
     * @param map
     * row              每页大小
     * page             页码
     * school_name      学校名称
     * country_code     国家编码(BaseCodeName的code)
     * world_rank_type  排名类型
     * cost_range
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("abroad/school/list")
    Call<ApiModel<ExpertLabel>> schoolList(@FieldMap HashMap<String,Object> map);

    /**
     * 院校首页-通过school_id查询
     * @param schoolId    学校id
     * @param studentId   学生id
     * @return
     */
    @Headers(Config.CUSTOM)
    @FormUrlEncoded
    @POST("abroad/school/detail")
    Call<ApiModel<AbroadSchool>> schoolDetail(@Field("school_id")int schoolId, @Field("student_id") int studentId);


    /**
     *  院校首页查询学校介绍、申请要求、人文与教学、花费说明、联系方式等扩展信息
     * @param schoolId
     * @return
     */
    @Headers(Config.COMMON)
    @FormUrlEncoded
    @POST("abroad/school/introduce")
    Call<ApiModel<AbroadSchool>> schoolIntroduce(@Field("id")int schoolId);


    /**
     * 留学院校首页咨询招生代表与顾问
     * @param schoolId  学校id
     * @return map
     * teacherList  List<UserSchoolTeacher> 招生代表列表
     * stafflist    List<AbroadAdviser>     留学顾问列表
     */
    @Headers(Config.COMMON)
    @FormUrlEncoded
    @POST("abroad/school/teacherList")
    Call<ApiModel<Map<String,Object>>> teacherList(@Field("school_id")int schoolId);


    /**
     * 出国留学-排行榜配置
     * @return code  type
     */
    @Headers(Config.COMMON)
    @FormUrlEncoded
    @POST("abroad/rank/config")
    Call<ApiModel<AbroadSchool>> rankConfig();


    /**
     * 院校 排行榜
     *
     * @param rows  每页大小
     * @param page  页码
     * @param type  排行榜类型(BaseCodeName的type)
     * @param obj   院校排行榜传school
     * @return
     */
    @Headers(Config.COMMON)
    @FormUrlEncoded
    @POST("abroad/rank/list")
    Call<ApiModel<AbroadSchoolRank>> schoolRankList(@Field("rows") int rows, @Field("page") int page, @Field("type") int type, @Field("obj") String obj);

    /**
     * 专业 排行榜
     *
     * @param rows  每页大小
     * @param page  页码
     * @param type  排行榜类型(BaseCodeName的type)
     * @param obj   专业排行榜传major
     * @return
     */
    @Headers(Config.COMMON)
    @FormUrlEncoded
    @POST("abroad/rank/list")
    Call<ApiModel<AbroadMajorRank>> majorRankList(@Field("rows") int rows, @Field("page") int page, @Field("type") int type, @Field("obj") String obj);


    /**
     * 学校在招专业
     * 根据学位类型和专业方向查找
     *
     * @param rows          每页大小
     * @param page          页码
     * @param schoolId      学校id
     * @param name          专业名称
     * @param courseType    学位类型
     * @param baseMajorCode 专业方向编码
     * @return
     */
    @Headers(Config.COMMON)
    @FormUrlEncoded
    @POST("abroad/schoolMajor/list")
    Call<ApiModel<List<AbroadSchoolMajor>>> majorList(@Field("rows") int rows, @Field("page") int page,
                                                            @Field("school_id") int schoolId, @Field("name") int name,
                                                            @Field("course_type") int courseType, @Field("base_major_code") int baseMajorCode);

    /**
     *  专业库-获取专业大类列表-不分页
     * @return
     */
    @Headers(Config.COMMON)
    @FormUrlEncoded
    @POST("abroad/baseMajor/list")
    Call<ApiModel<List<AbroadBaseMajor>>> baseMajorList();


    /**
     *  专业库-获取专业列表
     * @param rows          每页大小
     * @param page          页码
     * @param name          专业名称
     * @param parentCode    专业父级编码
     * @return
     */
    @Headers(Config.COMMON)
    @FormUrlEncoded
    @POST("abroad/major/list")
    Call<ApiModel<List<AbroadBaseMajor>>> majorList(@Field("rows") int rows, @Field("page") int page,
                                                                @Field("name") String name,@Field("parent_code") String parentCode);


    /**
     *  专业库-获取在招院校
     * @param rows          每页大小
     * @param page          页码
     * @param majorCode     专业code
     * @param courseType    学位类型
     * @return
     */
    @Headers(Config.COMMON)
    @FormUrlEncoded
    @POST("abroad/recruitSchool/list")
    Call<ApiModel<List<AbroadSchool>>> recruitSchoolList(@Field("rows") int rows, @Field("page") int page,
                                                                @Field("major_code") String majorCode,@Field("course_type") int courseType);

    /**
     * 院校详情-获取课程类别
     * @param schoolId
     * @return
     */
    @Headers(Config.COMMON)
    @FormUrlEncoded
    @POST("abroad/school/course")
    Call<ApiModel<String>> courseType(@Field("school_id") int schoolId);

    /**
     * 留学院校申请接口
     * @param map
     * student_id   学生id
     * school_id    学校id
     * course_type  学位类型
     * student_grade    学生当前年级
     * ielts_score  语言成绩
     * toefl_score  语言成绩托福
     * sat_score    标准化成绩SAT
     * act_score    标准化成绩ACT
     *
     * @return
     */
    @Headers(Config.CUSTOM)
    @FormUrlEncoded
    @POST("abroad/studentApply/save")
    Call<ApiModel> studentApply(@FieldMap HashMap<String,Object> map);


    /**
     * 留学首页学校广告列表
     * @return
     */
    @Headers(Config.COMMON)
    @FormUrlEncoded
    @POST("abroad/school/listIndex")
    Call<ApiModel<List<AbroadSchool>>> abroadHomeAdList();


    /**
     * 查询活跃大学
     * @return
     */
    @Headers(Config.COMMON)
    @FormUrlEncoded
    @POST("abroad/activeCollege/list")
    Call<ApiModel<List<AbroadSchool>>> collegeList();


    /**
     * 搜索招生代表
     * @param rows          每页大小
     * @param page          页码
     * @param schoolName    学校名称
     * @return
     */
    @Headers(Config.COMMON)
    @FormUrlEncoded
    @POST("abroad/foreignTeacher/list")
    Call<ApiModel<List<UserSchoolTeacher>>> teacherList(@Field("rows") int rows, @Field("page") int page,
                                                              @Field("school_name") int schoolName);

    /**
     * 获取个人顾问列表
     *
     * @param rows      每页大小
     * @param page      页码
     * @param serveArea 留学国家
     * @param serveType 服务类型
     * @param province  所在地
     * @param type      顾问类型 1个人顾问
     * @param keyword   顾问/机构名称
     * @return
     */
    @Headers(Config.COMMON)
    @FormUrlEncoded
    @POST("abroad/adviser/getList")
    Call<ApiModel<List<AbroadAdviser>>> adviserList(@Field("rows") int rows, @Field("page") int page,
                                                          @Field("serve_area") String serveArea, @Field("serve_type") int serveType,
                                                          @Field("province") String province, @Field("type") int type,
                                                          @Field("keyword") String keyword);

    /**
     *  获取机构顾问列表
     *
     * @param rows      每页大小
     * @param page      页码
     * @param serveArea 留学国家
     * @param serveType 服务类型
     * @param province  所在地
     * @param type      顾问类型 2机构
     * @param keyword   顾问/机构名称
     * @return
     */
    @Headers(Config.COMMON)
    @FormUrlEncoded
    @POST("abroad/adviser/getList")
    Call<ApiModel<List<SysGroup>>> adviserGroupList(@Field("rows") int rows, @Field("page") int page,
                                                     @Field("serve_area") String serveArea, @Field("serve_type") int serveType,
                                                     @Field("province") String province, @Field("type") int type,
                                                     @Field("keyword") String keyword);

    /**
     * 顾问详情
     * @param id    顾问id
     * @param type  顾问类型 1个人顾问 2机构员工顾问
     * @param stuId 学生id
     * @return
     */
    @Headers(Config.CUSTOM)
    @FormUrlEncoded
    @POST("abroad/adviser/getDetail")
    Call<ApiModel<AbroadAdviser>> adviserDetail(@Field("id") int id, @Field("type") int type,
                                                      @Field("stu_id") int stuId);

    /**
     * 获取留学服务评论信息
     * @param rows      每页大小
     * @param page      页码
     * @param accountId 账户id
     * @return  map
     *  count       int                     评论数量
     *  evaluate    List<AbroadEvaluate>    评论列表
     */
    @Headers(Config.CUSTOM)
    @FormUrlEncoded
    @POST("abroad/adviser/getEvaluate")
    Call<ApiModel<Map<String,Object>>> adviserEvaluate(@Field("rows") int rows, @Field("page") int page,
                                                             @Field("account_id") int accountId);
    /**
     * 关注留学顾问
     * @param stuId     学生id
     * @param adviserId 顾问id
     * @param type      类型 1个人顾问 2机构 顾问 3机构
     * @param name      顾问/机构名称
     * @param groupId   机构id 关注机构员工、机构时要传机构id
     * @return
     */
    @Headers(Config.CUSTOM)
    @FormUrlEncoded
    @POST("abroad/adviser/toAttention")
    Call<ApiModel> attentionAdviser(@Field("stu_id") int stuId, @Field("adviser_id") int adviserId,
                                          @Field("type") int type,@Field("name") String name,
                                          @Field("group_id") int groupId);


    /**
     * 取消关注留学顾问
     * @param stuId     学生id
     * @param type      类型 1 个人顾问
     * @param adviserId 顾问id
     * @param groupId   机构id   关注机构员工、机构时要传机构id
     * @return
     */
    @Headers(Config.CUSTOM)
    @FormUrlEncoded
    @POST("abroad/adviser/cancelAttention")
    Call<ApiModel> cancelAttentionAdviser(@Field("stu_id") int stuId,@Field("type") int type,
                                                @Field("adviser_id") int adviserId,@Field("group_id") int groupId);

    /**
     * 机构详情
     * @param groupId   机构id
     * @param stuId     学生id
     * @return
     */
    @Headers(Config.CUSTOM)
    @FormUrlEncoded
    @POST("abroad/adviser/getGroupDetail")
    Call<ApiModel<SysGroup>> getGroupDetail(@Field("group_id") int groupId,@Field("stu_id") int stuId);


    /**
     * 留学机构-经典案例列表
     * @param rows      每页大小
     * @param page      页码
     * @param groupId   机构id
     * @return
     */
    @Headers(Config.CUSTOM)
    @FormUrlEncoded
    @POST("abroad/adviser/caseList")
    Call<ApiModel<List<AbroadGroupCase>>> caseList(@Field("rows") int rows, @Field("page") int page,
                                                         @Field("group_id") int groupId);

    /**
     * 服务详情/热门服务
     * @param rows      每页大小
     * @param page      页码
     * @param id        个人顾问id/机构id
     * @param type      类型 1个人顾问  2机构员工顾问  3机构
     * @return
     */
    @Headers(Config.CUSTOM)
    @FormUrlEncoded
    @POST("abroad/adviser/getServiceList")
    Call<ApiModel<List<SysGoods>>> getServiceList(@Field("rows") int rows, @Field("page") int page,
                                        @Field("id") int id,@Field("type") int type);


    /**
     * 获取标签、文本
     * @param accountId 账户id
     * @return
     *
     * labelList    List<AbroadEvaluateLabel>
     *     AbroadEvaluateLabel :
     *              evaluate_id 评价id;
     *              label_id    标签id;
     *              label_name  标签名称;
     *              label_num   标签数量 ;
     *
     * text JSON:
     *      good_num    商品评价个数
     *      average     评价平均值
     *      order_num   商品数量
     *      scale      good_num/order_num*100 %  好评%比
     *
     *     (ಥ_ಥ)
     *
     */
    @Headers(Config.CUSTOM)
    @FormUrlEncoded
    @POST("abroad/adviser/getLabel")
    Call<ApiModel<String>> getLabel(@Field("account_id") int accountId);

    /**
     * 留学服务列表搜索接口
     * @param rows          每页大小
     * @param page          页码
     * @param type          类型，1境内，2境外
     * @param serveArea     国家  默认美国
     * @param productCode   商品类型
     * @param title         商品名称
     * @return
     */
    @Headers(Config.CUSTOM)
    @FormUrlEncoded
    @POST("abroad/service/list")
    Call<ApiModel<List<SysGoods>>> abroadServiceList(@Field("rows") int rows, @Field("page") int page,
                                                           @Field("type") int type, @Field("serve_area") String serveArea,
                                                           @Field("product_code") String productCode, @Field("title") String title);


    /**
     * 留学商品详情
     * @param code  商品编码
     * @return
     */
    @Headers(Config.CUSTOM)
    @FormUrlEncoded
    @POST("abroad/service/detail")
    Call<ApiModel<List<abroadGoods>>> abroadServiceDetail(@Field("goods_code") String code);


    /**
     * 更多评论
     * @param rows  每页大小
     * @param page  页码
     * @param code  商品编码
     * @return
     */
    @Headers(Config.CUSTOM)
    @FormUrlEncoded
    @POST("abroad/service/goods/comment")
    Call<ApiModel<List<AbroadEvaluate>>> goodsComment(@Field("rows") int rows, @Field("page") int page,
                                                            @Field("goods_code") String code);

    /**
     * 留学服务创建订单
     * @param accountId     账户id
     * @param adviserId     顾问id
     * @param type          类型 1 个人顾问 2 机构顾问
     * @param code          商品编码
     * @param productCode   商品类型
     * @return  orderId     订单id
     */
    @Headers(Config.CUSTOM)
    @FormUrlEncoded
    @POST("abroad/service/createOrder")
    Call<ApiModel<String>> goodsComment(@Field("account_id") int accountId, @Field("adviser_id") int adviserId,
                                                            @Field("type") int type,@Field("goods_code") String code,
                                                            @Field("product_code") String productCode);


    /**
     * 留学首页活动
     * @param top 固定值 请传 "top"
     * @return map
     *  id  int     活动id
     *  img String  活动图片
     */
    @Headers(Config.COMMON)
    @FormUrlEncoded
    @POST("abroad/home/activity/list")
    Call<ApiModel<Map<String,Object>>> homeActivityList(@Field("top") String top);

    /**
     * 留学活动列表
     * @return map
     *  id  int     活动id
     *  img String  活动图片
     */
    @Headers(Config.COMMON)
    @FormUrlEncoded
    @POST("abroad/home/activity/list")
    Call<ApiModel<Map<String,Object>>> homeActivityList();

    /**
     * 留学活动详情
     * @param rows  每页大小
     * @param page  页码
     * @param id    活动id
     * @return
     */
    @Headers(Config.CUSTOM)
    @FormUrlEncoded
    @POST("abroad/home/activity/detail")
    Call<ApiModel<AbroadActive>> homeActivityList(@Field("rows") int rows, @Field("page") int page,
                                                        @Field("id") int id);

}
