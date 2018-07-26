package com.qxb.student.common.module;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.alibaba.fastjson.JSONObject;
import com.qxb.student.common.module.api.SmsApi;
import com.qxb.student.common.module.api.UserApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.User;
import com.qxb.student.common.utils.UserCache;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

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
        Disposable disposable = httpUtils.convert(httpUtils.create(UserApi.class).login(account, password),
                new Consumer<ApiModel<User>>() {
                    @Override
                    public void accept(ApiModel<User> apiModel) {
                        if (apiModel.getCode() == 1) {
                            userMutableLiveData.postValue(apiModel.getData());
                            roomUtils.userDao().insert(apiModel.getData());
                            UserCache.getInstance().update(apiModel.getData());
                        }
                    }
                }).subscribe();
        httpUtils.addDisposable(disposable);
        return userMutableLiveData;
    }

    public LiveData<ApiModel<String>> ThirdLogin(String type, String open_id) {
        Disposable disposable = httpUtils.convert(httpUtils.create(UserApi.class).thirdPartyLogin(type, open_id),
                new Consumer<ApiModel<String>>() {
                    @Override
                    public void accept(ApiModel<String> userApiModel) {
                        thirdLoginLiveData.postValue(userApiModel);
                    }
                }).subscribe();
        httpUtils.addDisposable(disposable);
        return thirdLoginLiveData;
    }

    public LiveData<ApiModel<JSONObject>> sendCode(String phone, String type) {
        Disposable disposable = httpUtils.convert(httpUtils.create(SmsApi.class).CreateCode(phone, type), new Consumer<ApiModel<JSONObject>>() {
            @Override
            public void accept(ApiModel<JSONObject> stringApiModel) {
                sendCodeLiveData.postValue(stringApiModel);
            }
        }).subscribe();
        httpUtils.addDisposable(disposable);
        return sendCodeLiveData;
    }

    public LiveData<ApiModel<JSONObject>>checkCode(String phone, String code){
        Disposable disposable=httpUtils.convert(httpUtils.create(SmsApi.class).vaildCode(phone, code), new Consumer<ApiModel<JSONObject>>() {
            @Override
            public void accept(ApiModel<JSONObject> stringApiModel) throws Exception {
                checkCodeLiveData.postValue(stringApiModel);
            }
        }).subscribe();
        httpUtils.addDisposable(disposable);
        return checkCodeLiveData;
    }
}
