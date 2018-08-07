package com.qxb.student.common.module;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.SchoolDetail;
import com.qxb.student.common.module.bean.SchoolVideo;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * @author winky
 * @date 2018/7/24
 */
public interface TestApi {

    /**
     * 直播首页广告 2.3 新版本 新图片
     *
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @POST("chatRoom/liveHomeAd23")
    Call<ApiModel<String>> getLiveHomeAd();


    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("baseNews/connectSchool")
    Call<ApiModel<String>> connectSchool(@FieldMap Map<String, String> conditionMap);
}
