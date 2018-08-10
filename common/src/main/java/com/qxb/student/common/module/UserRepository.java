package com.qxb.student.common.module;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSONObject;
import com.qxb.student.common.http.task.ApiModelHandle;
import com.qxb.student.common.http.task.DataHandle;
import com.qxb.student.common.http.task.HttpTask;
import com.qxb.student.common.module.api.SmsApi;
import com.qxb.student.common.module.api.UserApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.User;
import com.qxb.student.common.utils.LibControl;
import com.qxb.student.common.utils.OtherHelper;
import com.qxb.student.common.utils.UserCache;

/**
 * 用户资料
 *
 * @author winky
 * @date 2018/7/21
 */
public class UserRepository extends BaseRepository {

    private MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<ApiModel<String>> thirdLoginLiveData = new MutableLiveData<>();
    private MutableLiveData<ApiModel<JSONObject>> sendCodeLiveData = new MutableLiveData<>();
    private MutableLiveData<ApiModel<JSONObject>> checkCodeLiveData = new MutableLiveData<>();

    public LiveData<User> login(final String account, String password) {
        new HttpTask<User>()
                .netLive(userMutableLiveData)
                .call(httpUtils.create(UserApi.class).login(account, password))
                .handle(new DataHandle<User>() {
                    @Override
                    public void handle(@NonNull User data) {
                        data.setTelphone(account);
                        roomUtils.userDao().insert(data);
                        UserCache.getInstance().update(data);
                        LibControl.getInstance().loadOther(data);
                    }
                }).start();
        return userMutableLiveData;
    }

    public LiveData<ApiModel<String>> ThirdLogin(String type, String open_id) {
        new HttpTask<String>()
                .call(httpUtils.create(UserApi.class).thirdPartyLogin(type, open_id))
                .apiModel(new ApiModelHandle<String>() {
                    @Override
                    public void handle(@NonNull ApiModel<String> apiModel, int pageIndex) {
                        thirdLoginLiveData.postValue(apiModel);
                    }
                }).start();
        return thirdLoginLiveData;
    }

    public LiveData<ApiModel<JSONObject>> sendCode(String phone, String type) {
        new HttpTask<JSONObject>()
                .call(httpUtils.create(SmsApi.class).CreateCode(phone, type))
                .apiModel(new ApiModelHandle<JSONObject>() {
                    @Override
                    public void handle(@NonNull ApiModel<JSONObject> apiModel, int pageIndex) {
                        sendCodeLiveData.postValue(apiModel);
                    }
                }).start();
        return sendCodeLiveData;
    }

    public LiveData<ApiModel<JSONObject>> checkCode(String phone, String code) {
        new HttpTask<JSONObject>()
                .call(httpUtils.create(SmsApi.class).vaildCode(phone, code))
                .apiModel(new ApiModelHandle<JSONObject>() {
                    @Override
                    public void handle(@NonNull ApiModel<JSONObject> apiModel, int pageIndex) {
                        checkCodeLiveData.postValue(apiModel);
                    }
                }).start();
        return checkCodeLiveData;
    }

    @Override
    public void onCleared() {
        userMutableLiveData = null;
        thirdLoginLiveData = null;
        sendCodeLiveData = null;
        checkCodeLiveData = null;
    }
}
