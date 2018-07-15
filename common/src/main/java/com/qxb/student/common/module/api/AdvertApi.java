package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AdvertApi {

    @Headers(Config.AUTH_COMMON)
    @POST("chatRoom/liveHomeAd23")
    Observable<ApiModel<String>> getLiveHomeAd();
}
