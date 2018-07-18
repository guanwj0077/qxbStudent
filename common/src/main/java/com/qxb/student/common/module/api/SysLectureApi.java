package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 听讲座
 * @author
 */
public interface SysLectureApi {

    /**
     * 新版听讲座视频列表
     * @param accountId 账户id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("article/lecture/list2")
    Observable<ApiModel<String>> lectureList(@Query("account_id") String accountId);


}
