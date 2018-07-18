package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AdvertApi {

    /**
     * 直播首页广告 2.3 新版本 新图片
     *
     * @return
     */
    @Headers(Config.AUTH_COMMON)
    @FormUrlEncoded
    @POST("chatRoom/liveHomeAd23")
    Observable<ApiModel<String>> getLiveHomeAd();
}
