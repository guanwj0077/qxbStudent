package com.qxb.student.common.module;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;

import retrofit2.Call;
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
}
