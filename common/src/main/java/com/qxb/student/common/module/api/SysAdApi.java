package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.SysAd;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 系统广告
 */
public interface SysAdApi {

    /***
     * 首页轮播图广告,求学头条等广告列表
     * @param type
     * [
     *  home_ad：首页轮播图广告
     *  studying_headlines：求学头条
     *  with_test_ad：伴考广告
     *  product_ad1：艺考培训
     *  product_ad2：出国留学
     *  product_ad3：法国直通车
     *  product_ad4：职业技能
     * ]
     * @param province
     * @param studentId
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("sysAd/list")
    Observable<ApiModel<List<SysAd>>> getSysAdList(@Query("type") String type, @Query("province") String province, @Query("student_id") String studentId);



}
