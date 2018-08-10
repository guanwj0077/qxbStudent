package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 用户资料
 * @author caiZong
 */
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
    Call<ApiModel<User>> login(@Field("login_name") String account, @Field("login_pwd") String password);

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
    Call<ApiModel<String>> saveNewPwd(@Field("password") String password, @Field("tel") String tel, @Field("smsCode") String smsCode);

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
    Call<ApiModel<User>> getJpushConfig(@Field("jtype") String jtype, @Field("id") String id);

    /**
     * 用户获取token
     *
     * @param accountId 账户id
     */
    @Headers({Config.AUTH_CUSTOM})
    @FormUrlEncoded
    @POST("chat/token")
    Call<ApiModel<String>> token(@Field("account_id") String accountId);

    /**
     * 智能选校-申请清除位次
     *
     * @param phone
     * @return
     */
    @Headers({Config.AUTH_CUSTOM})
    @FormUrlEncoded
    @POST("cleanPrecedence")
    Call<ApiModel<String>> cleanPrecedence(@Field("phone") String phone);

    /**
     * 通过账户id获取实体信息
     *
     * @param accountId
     * @return
     */
    @Headers({Config.AUTH_CUSTOM})
    @FormUrlEncoded
    @POST("getSubjectEntity")
    Call<ApiModel<User>> getSubjectEntity(@Field("account_id") String accountId);

    /**
     * 退出登录清除缓存
     *
     * @param accountId
     * @return
     */
    @Headers({Config.AUTH_CUSTOM})
    @FormUrlEncoded
    @POST("logout")
    Call<ApiModel<String>> logOut(@Field("account_id") String accountId);

    /**
     * 写登录记录
     *
     * @param accountId
     * @return
     */
    @Headers({Config.AUTH_CUSTOM})
    @FormUrlEncoded
    @POST("loginRecord")
    Call<ApiModel<String>> loginRecord(@Field("account_id") String accountId);

    /**
     * 学生端三方登录接口
     *
     * @param type   类型 1：QQ 2：微信（必传）
     * @param openId 三方的openID（必传）
     * @return
     */
    @Headers({Config.AUTH_COMMON})
    @FormUrlEncoded
    @POST("third_party_login")
    Call<ApiModel<String>> thirdPartyLogin(@Field("type") String type, @Field("open_id") String openId);

    /**
     * 注册
     *
     * @param telphone  手机号（必传）
     * @param password  密码（必传）
     * @param pic       头像链接
     * @param nickName  昵称
     * @param type      1：QQ 2：微信
     * @param open_id   三方登录open_id
     * @param hasRegist 1:已注册（三方登录绑定的手机号已经注册） 非1：未注册
     * @param appType   用户类型1:学生、2：老师、3：代理
     * @return
     */
    @FormUrlEncoded
    @POST("userStudent/regist_new")
    Call<ApiModel<String>> registNew(@Field("telphone") String telphone, @Field("password") String password,
                                           @Field("pic") String pic, @Field("nick_name") String nickName, @Field("type") String type,
                                           @Field("open_id") String open_id, @Field("has_regist") String hasRegist, @Field("app_type") String appType);

}
