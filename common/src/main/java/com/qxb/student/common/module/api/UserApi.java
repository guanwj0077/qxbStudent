package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.User;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserApi {

    /**
     * 登录
     *
     * @param account  账号
     * @param password 密码
     * @return
     */
    @Headers({Config.AUTH_COMMON})
    @FormUrlEncoded
    @POST("login_new/stuapp")
    Observable<ApiModel<User>> login(@Field("login_name") String account, @Field("login_pwd") String password);

    /**
     * 用户修改密码
     *
     * @param password 未加密的新密码
     * @param tel      接收短信的手机号
     * @param smsCode  验证码
     * @return
     */
    @Headers({Config.AUTH_COMMON})
    @FormUrlEncoded
    @POST("user/forgotpwd")
    Observable<ApiModel<String>> saveNewPwd(@Field("password") String password, @Field("tel") String tel, @Field("smsCode") String smsCode);

    /**
     * 用户获取极光配置
     *
     * @param jtype gzxs 学生  dxls 教师
     * @param id    学生或者老师id
     * @return
     */
    @Headers({Config.AUTH_COMMON})
    @FormUrlEncoded
    @POST("jpush/config")
    Observable<ApiModel<User>> getJpushConfig(@Field("jtype") String jtype, @Field("id") String id);

    /**
     * 用户获取token
     *
     * @param accountId 账户id
     * @return
     */
    @Headers({Config.AUTH_CUSTOM})
    @FormUrlEncoded
    @POST("chat/token")
    Observable<ApiModel<String>> token(@Field("account_id") String accountId);

    /**
     * 智能选校-申请清除位次
     *
     * @param phone
     * @return
     */
    @Headers({Config.AUTH_CUSTOM})
    @FormUrlEncoded
    @POST("cleanPrecedence")
    Observable<ApiModel<String>> cleanPrecedence(@Field("phone") String phone);

    /**
     * 通过账户id获取实体信息
     *
     * @param accountId
     * @return
     */
    @Headers({Config.AUTH_CUSTOM})
    @FormUrlEncoded
    @POST("getSubjectEntity")
    Observable<ApiModel<User>> getSubjectEntity(@Field("account_id") String accountId);

    /**
     * 退出登录清除缓存
     *
     * @param accountId
     * @return
     */
    @Headers({Config.AUTH_CUSTOM})
    @FormUrlEncoded
    @POST("logout")
    Observable<ApiModel<String>> logOut(@Field("account_id") String accountId);

    /**
     * 写登录记录
     *
     * @param accountId
     * @return
     */
    @Headers({Config.AUTH_CUSTOM})
    @FormUrlEncoded
    @POST("loginRecord")
    Observable<ApiModel<String>> loginRecord(@Field("account_id") String accountId);
}
