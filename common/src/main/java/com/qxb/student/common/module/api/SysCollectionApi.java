package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.SysCollection;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 收藏
 * @author
 */
public interface SysCollectionApi {

    /**
     * 我的收藏列表
     * @param stuId
     * @param itemType 1:专业 2：志愿 3：学校  6:自招院校 8 艺考资讯 9 艺考院校 10 伴考资讯
     * @param page
     * @param rows 默认20
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded    @POST("collection/list")
    Observable<ApiModel<List<SysCollection>>> collectionList(@Field("stu_id") String stuId, @Field("item_type") String itemType, @Field("page") String page, @Field("rows") String rows);

    /**
     * 收藏
     * @param stuId 学生id
     * @param itemId 收藏对象id
     * @param itemType 1:专业 2：志愿	 3：学校  6:自招院校 8 艺考资讯 9 艺考院校 10 伴考资讯 15：留学院校
     * @param itemName 收藏对象名称(非必传)
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("collection/add")
    Observable<ApiModel<String>> collectionAdd(@Field("stu_id") String stuId, @Field("item_id") String itemId, @Field("item_type") String itemType, @Field("item_name") String itemName);

    /**
     * 取消收藏
     * @param stuId
     * @param itemId
     * @param itemType
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded    @POST("collection/cancel")
    Observable<ApiModel<String>> collectionCancel(@Field("stu_id") String stuId,@Field("item_id") String itemId, @Field("item_type") String itemType);

}
