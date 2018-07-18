package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.User;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserApi {

    /**
     * 登录
     * @param account  账号
     * @param password 密码
     * @return
     */
    @Headers({Config.AUTH_COMMON})
    @POST("login_new/stuapp")
    Observable<ApiModel<User>> login(@Query("login_name") String account, @Query("login_pwd") String password);

    /**
     * 用户修改密码
     * @param password 未加密的新密码
     * @param tel 接收短信的手机号
     * @param smsCode 验证码
     * @return
     */
    @Headers({Config.AUTH_COMMON})
    @POST("user/forgotpwd")
    Observable<ApiModel<String>> saveNewPwd(@Query("password") String password, @Query("tel") String tel,@Query("smsCode") String smsCode);

    /**
     * 用户获取极光配置
     * @param jtype gzxs 学生  dxls 教师
     * @param id 学生或者老师id
     * @return
     */
    @Headers({Config.AUTH_COMMON})
    @POST("jpush/config")
    Observable<ApiModel<User>> getJpushConfig(@Query("jtype") String jtype, @Query("id") String id);

    /**
     * 用户获取token
     * @param accountId 账户id
     * @return
     */
    @Headers({Config.AUTH_CUSTOM})
    @POST("chat/token")
    Observable<ApiModel<String>> token(@Query("account_id") String accountId);

    /**
     * 智能选校-申请清除位次
     * @param phone
     * @return
     */
    @Headers({Config.AUTH_CUSTOM})
    @POST("cleanPrecedence")
    Observable<ApiModel<String>> cleanPrecedence(@Query("phone") String phone);
}
