package com.qxb.student.common.module;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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


                    }
                }).subscribe();
        httpUtils.addDisposable(disposable);
        return thirdLoginLiveData;
    }


}
