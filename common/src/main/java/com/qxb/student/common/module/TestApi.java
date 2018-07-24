package com.qxb.student.common.module;

import com.alibaba.fastjson.JSONObject;
import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @author winky
 * @date 2018/7/24
 */
public interface TestApi {

    @Headers(Config.AUTH_COMMON)
    @POST("SMS/CreateCode_new/{tel}/{type}")
    Observable<ApiModel<JSONObject>> CreateCode(@Path("tel") String tel, @Path("type") String type);
}
