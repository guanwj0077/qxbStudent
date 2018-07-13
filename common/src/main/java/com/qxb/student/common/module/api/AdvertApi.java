package com.qxb.student.common.module.api;

import com.qxb.student.common.module.bean.ApiModel;

import io.reactivex.Observable;
import retrofit2.http.POST;

public interface AdvertApi {

    @POST("chatRoom/liveHomeAd23")
    Observable<ApiModel<String>> getLiveHomeAd();
}
