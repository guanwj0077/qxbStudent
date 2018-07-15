package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.Test;
import com.qxb.student.common.module.bean.User;
import com.qxb.student.common.utils.UserCache;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface UserApi {

    /**
     * 获取信息
     *
     * @return
     */
    @Headers({Config.AUTH_COMMON})
    @GET("login_new/stuapp")
    Observable<ApiModel<User>> login(@Query("login_name") String name, @Query("login_pwd") String password);
}
