package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.SysCollection;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

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
    @POST("collection/list")
    Observable<ApiModel<List<SysCollection>>> collectionList(@Query("stu_id") String stuId, @Query("item_type") String itemType, @Query("page") String page, @Query("rows") String rows);

    /**
     * 收藏
     * @param stuId 学生id
     * @param itemId 收藏对象id
     * @param itemType 1:专业 2：志愿	 3：学校  6:自招院校 8 艺考资讯 9 艺考院校 10 伴考资讯 15：留学院校
     * @param itemName 收藏对象名称(非必传)
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("collection/add")
    Observable<ApiModel<String>> collectionAdd(@Query("stu_id") String stuId,@Query("item_id") String itemId, @Query("item_type") String itemType,@Query("item_name") String itemName);

    /**
     * 取消收藏
     * @param stuId
     * @param itemId
     * @param itemType
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("collection/cancel")
    Observable<ApiModel<String>> collectionCancel(@Query("stu_id") String stuId,@Query("item_id") String itemId, @Query("item_type") String itemType);

}
